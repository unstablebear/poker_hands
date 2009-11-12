package com.zl.poker;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Combination {

	private List<Card> cards = new ArrayList<Card>();
	private List<Card> restCards = new ArrayList<Card>();

	private CombinationType combinationType = CombinationType.HIGH_CARD;

	private Combination() {
	}

	public Combination(List<Card> cardsSet) {

		// System.out.println("<>");
		int pairs_cnt = 0;
		int triples_cnt = 0;
		int quad_cnt = 0;
		int[] pairs = new int[15];
		int[] flush = new int[5];

		List<Card> aces = getAces(cardsSet);		
		
		// Straights ?
		Collections.sort(cardsSet);
		List<List<Card>> straights = getAllStraihgts(cardsSet, aces);
		if(straights.size() > 0) {
			if(straights.size() > 1) {
				List<Card> max = straights.get(0);
				for(int i = 1; i < straights.size(); i++) {
					int cmp = compareStraights(straights.get(i - 1), straights.get(i));
					if(cmp < 0) {
						max = straights.get(i);
					}
				}
				cards = max;
			} else {
				cards = straights.get(0);
			}
			if(checkForFlush(cards, 0)) {
				if(cards.get(4).getValue() == 10) {
					combinationType = CombinationType.FLUSH_ROYAL;
				} else {
					combinationType = CombinationType.STRAIGHT_FLUSH;
				}
			} else {
				combinationType = CombinationType.STRAIGHT;
			}
		}
		
		// Pairs, Triplets, Quads ?
		if(combinationType.val < CombinationType.QUAD.val) {
			for (int i = 0; i < cardsSet.size(); i++) {
				boolean isFlushExists = flush[cardsSet.get(i).getSuit()] > 0;
				if (pairs[cardsSet.get(i).getValue()] == 0) {
					for (int j = i + 1; j < cardsSet.size(); j++) {
						if (cardsSet.get(i).getValue() == cardsSet.get(j)
								.getValue()) {
						// System.out.println("! " + cardsSet.get(i).getValue()
						// + " " + cardsSet.get(j).getValue());
							pairs[cardsSet.get(i).getValue()]++;
						}
						if (!isFlushExists
								&& cardsSet.get(i).getSuit() == cardsSet.get(j)
									.getSuit()) {
						// System.out.println("! " + cardsSet.get(i).getSuit() +
						// " " + cardsSet.get(j).getSuit());
						// pairs[cardsSet.get(i).getValue()]++;
							flush[cardsSet.get(i).getSuit()]++;
						// System.out.println("flash_cnt = " +
						// flash[cardsSet.get(i).getSuit()]);
						}
					}
				}
			}

			for (int i = 2; i < 15; i++) {
				// System.out.println("? " + pairs[i] + " " + i);
				switch (pairs[i]) {
				case 1:
					pairs_cnt++;
					break;
				case 2:
					triples_cnt++;
					break;
				case 3:
					quad_cnt++;
					break;
				default:
					continue;
				}
				for (int j = 0; j < cardsSet.size(); j++) {
					if (cardsSet.get(j).getValue() == i) {
						cards.add(cardsSet.get(j));
					}
				}
				if (triples_cnt > 0)
					break;
			}
	
			if (quad_cnt == 1) {
				combinationType = CombinationType.QUAD;
			} else if (triples_cnt == 1) {
				combinationType = CombinationType.TRIPLE;
			} else if (pairs_cnt == 1) {
				combinationType = CombinationType.PAIR;
			} else if (pairs_cnt == 2) {
				combinationType = CombinationType.DOUBLE_PAIR;
			}
		}
		
		// проверка на full house
		if (combinationType.val > 0
				&& combinationType.val < CombinationType.FULL_HOUSE.val
				&& pairs_cnt > 0 && triples_cnt > 0) {
			combinationType = CombinationType.FULL_HOUSE;
		}

		// System.out.println("CombinationType = " + combinationType);
		if (combinationType.equals(CombinationType.HIGH_CARD)) {
			for (int i = 0; i < flush.length; i++) {
				// System.out.println("flash = " + flash[i]);
				if (flush[i] > 3) {
					combinationType = CombinationType.FLUSH;
					for (int j = 0; j < cardsSet.size(); j++) {
						if (cardsSet.get(j).getSuit() == flush[i]) {
							cards.add(cardsSet.get(j));
						}
					}
					break;
				}
			}
		}
		
		if (combinationType.val > CombinationType.HIGH_CARD.val) {
			for (int j = 0; j < cardsSet.size(); j++) {
				if (!cards.contains(cardsSet.get(j))) {
					restCards.add(cardsSet.get(j));
				}
			}
		}
		Collections.sort(cards);
		Collections.sort(restCards);
	}

	private List<Card> getAces(List<Card> cardsSet) {
		List<Card> aces = new ArrayList<Card>();
		for(int i = 0; i < cardsSet.size(); i++) {
			if(cardsSet.get(i).getValue() == 14) {
				aces.add(cardsSet.get(i));
			}
		}
		return aces;
	}

	public CombinationType getCombinationType() {
		return this.combinationType;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public List<Card> getRestCards() {
		return this.restCards;
	}

	private static boolean checkForFlush(List<Card> cardsList, int start) {
		if (start < 0 || cardsList.size() - start < 5) {
			throw new IllegalArgumentException(String.format(
					"start index = %s ; cards list size = %s", start, cardsList
							.size()));
		}
		for (int i = start + 1; i < start + 5; i++) {
			System.out.println("CheckForFlush : "
					+ cardsList.get(i - 1).getSuit() + " "
					+ cardsList.get(i).getSuit());
			if (cardsList.get(i - 1).getSuit() != cardsList.get(i).getSuit()) {
				return false;
			}
		}
		return true;
	}

	public static List<List<Card>> getAllStraihgts(List<Card> cardsList, List<Card> aces) {
		List<List<Card>> result = new ArrayList<List<Card>>();

		for(int i = 0; i < cardsList.size() - 4; i++) {
			List<List<Card>> straights = getStraightAtPosition(cardsList, i, aces);
			for (List<Card> list : straights) {
				if(list.size() == 4 || list.size() == 5) {
					result.add(list);	
				}
			}
		}
		return result;
	}

	public static List<List<Card>> getStraightAtPosition(List<Card> cardsList,
			int start, List<Card> aces) {
		if (start > cardsList.size() - 5 || start < 0) {
			throw new IllegalArgumentException(String.format(
					"start index = %s ; cards list size = %s", start, cardsList
							.size()));
		}
		boolean isStraight = false;
		List<List<Card>> result = new ArrayList<List<Card>>();
		result.add(new ArrayList<Card>());
		int i = start;

		while (i < start + 5) {
			int card1 = cardsList.get(i).getValue();
			int card2 = cardsList.get(i + 1).getValue();

			boolean isCurrentMoreByOneThanNext = card1 == card2 + 1;
			boolean isCurrentEqualsNext = card1 == card2;
			boolean isCurrentCardHasMoreThanOneFollowing = cardsList.size() > i + 1;
			boolean isCurrentIsBrokenFirstButAceExists = (!isCurrentEqualsNext && i == start && aces.size() > 0 && cardsList.get(start + 4).getValue() == 2);

			if (isCurrentMoreByOneThanNext || (isCurrentCardHasMoreThanOneFollowing && isCurrentEqualsNext)) {
				List<List<Card>> newAlternatives = new ArrayList<List<Card>>();
				if(result.get(0).size() == 4) {
					isStraight = true;
				}
				int ii = i;
				for (List<Card> lc : result) {
					if (card1 == card2) { // two equal values cards
						int k = i + 1;
						while(k < cardsList.size()) {
							if (cardsList.get(i).getValue() == cardsList.get(k).getValue()) {
								List<Card> newAlternative = new ArrayList<Card>();
								newAlternative.addAll(lc);
								newAlternative.add(cardsList.get(k));
								newAlternatives.add(newAlternative);
								k++;
							} else {
								break;
							}
						}	
						lc.add(cardsList.get(i));
						ii = k - 1;
					} else {
						lc.add(cardsList.get(i));
					}
				}
				start+= ii - i;
				i = ii;
				result.addAll(newAlternatives);
				isStraight = true;
				i++;
				if(i + 1 == cardsList.size()) {
					if(cardsList.get(i).getValue() + 1 == cardsList.get(i - 1).getValue()) {
						for (List<Card> lc : result) {
							lc.add(cardsList.get(i));
						}
					}
					break;
				}
			} else {
				if(!isCurrentIsBrokenFirstButAceExists) {
					isStraight = false;	
					break;
				} else {
					i++;
				}
			}
		}
		if(!isStraight) {
			result.clear();
		}
		List<List<Card>> modified = new ArrayList<List<Card>>();
		List<List<Card>> withAces = new ArrayList<List<Card>>();
		for(Card ace : aces) {
			for(List<Card> cl : result) {
				if(cl.size() == 4 && cl.get(3).getValue() == 2) {
					List<Card> newWithAces = new ArrayList<Card>();
					newWithAces.addAll(cl);
					newWithAces.add(ace);
					Collections.sort(newWithAces);
					withAces.add(newWithAces);
					modified.add(cl);
				}
			}
		}
		result.removeAll(modified);
		result.addAll(withAces);
		return result;
	}

	/*
	 * Принимает на вход два списка со стритами. Если первый больше, возвращается положительное значение, если меньше -
	 * отрицательное. Если стриты равны то возвращается 0.
	 */
	public static int compareStraights(List<Card> cl1, List<Card> cl2) {
		int result = 0;
		
		boolean isFlush1 = checkForFlush(cl1, 0);
		boolean isFlush2 = checkForFlush(cl2, 0);

		boolean minorAce1 = (cl1.get(0).getValue() == 14 && cl1.get(4).getValue() == 2);
		boolean minorAce2 = (cl2.get(0).getValue() == 14 && cl2.get(4).getValue() == 2);

		int majorIdx1 = minorAce1 ? 1 : 0;
		int majorIdx2 = minorAce2 ? 1 : 0;

		int minorIdx1 = minorAce1 ? 0 : 4;
		int minorIdx2 = minorAce2 ? 0 : 4;
		
		int minor1 = cl1.get(minorIdx1).getValue();
		int minor2 = cl2.get(minorIdx2).getValue();
		
		int major1 = cl1.get(majorIdx1).getValue();
		int major2 = cl2.get(majorIdx2).getValue();
		
		
		if(!(isFlush1 || isFlush2)) {
			result = major1 - major2; 
			if(result == 0) {
				for(int i = 0; i < 3; i++) {
					result = cl1.get(majorIdx1 + i).getValue() - cl2.get(majorIdx2 + i).getValue();
					if(result != 0) {
						break;
					}
				}
				if(result == 0) {
					result = minor1 - minor2;
					if(result == 0) {
						result = cl1.get(majorIdx1).getSuit() - cl2.get(majorIdx2).getSuit();
						if(result == 0) {
							for(int i = 0; i < 3; i++) {
								result = cl1.get(majorIdx1 + i).getSuit() - cl2.get(majorIdx2 + i).getSuit();
								if(result != 0) {
									break;
								}
							}
						}
						if(result == 0) {
							result = cl1.get(minorIdx1).getSuit() - cl2.get(minorIdx2).getSuit();
						}
					}
				}
			}
		} else if(isFlush1 && !isFlush2) {
			result = 1;
		} else if(!isFlush1 && isFlush2) {
			result = -1;
		} else {
			if(minor1 == 10 && minor2 != 10) {
				result = 1;
			} else if(minor1 != 10 && minor2 == 10) {
				result = -1;
			} else {
				result = cl1.get(0).getSuit() - cl2.get(0).getSuit();
			}
		} 
		return result;
	}
	
}
