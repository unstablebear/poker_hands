package com.zl.poker;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Combination implements Comparable {

	private List<Card> cards = new ArrayList<Card>();
	private List<Card> restCards = new ArrayList<Card>();

	private CombinationType combinationType = CombinationType.HIGH_CARD;

	private Combination() {
	}

	public Combination(List<Card> cardsSet) {

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
							pairs[cardsSet.get(i).getValue()]++;
						}
						if (!isFlushExists
								&& cardsSet.get(i).getSuit() == cardsSet.get(j)
									.getSuit()) {
							flush[cardsSet.get(i).getSuit()]++;
						}
					}
				}
			}

			for (int i = 14; i >= 2; i--) {
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
				if ((triples_cnt > 0 && pairs_cnt > 0) || quad_cnt > 0)
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

		if (combinationType.equals(CombinationType.HIGH_CARD)) {
			for (int i = 0; i < flush.length; i++) {
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
		} else {
			restCards.addAll(cardsSet);
		}
		Collections.sort(cards);
		Collections.sort(restCards);
	}

	// возвращает список тузов в списке карт
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

	public List<Card> getAllCards() {
		return new ArrayList() {{ addAll(cards); addAll(restCards); }};
	}
	
	// проверить список карт на совпадающие масти(флеш) с заданной позиции
	private static boolean checkForFlush(List<Card> cardsList, int start) {
		if (start < 0 || cardsList.size() - start < 5) {
			throw new IllegalArgumentException(String.format(
					"start index = %s ; cards list size = %s", start, cardsList
							.size()));
		}
		for (int i = start + 1; i < start + 5; i++) {
			if (cardsList.get(i - 1).getSuit() != cardsList.get(i).getSuit()) {
				return false;
			}
		}
		return true;
	}

	public static List<List<Card>> getAllStraihgts(List<Card> cardsList, List<Card> aces) {
		List<List<Card>> result = new ArrayList<List<Card>>();

		int border = aces.size() > 0 ? 3 : 4; 
		for(int i = 0; i < cardsList.size() - border; i++) {
			List<List<Card>> straights = getStraightAtPosition(cardsList, i, aces);
			for (List<Card> list : straights) {
				if(list.size() == 5) {
					result.add(list);	
				}
			}
		}
		return result;
	}

	/* 
	 * Возвращает список стритов начинающихся с заданной позиции из комбинации карт. 
	 */
	public static List<List<Card>> getStraightAtPosition(List<Card> cardsList,
			int start, List<Card> aces) {
		
		int i = start + 1;
		int cardsCount = 0;
		
		List<List<Card>> result = new ArrayList<List<Card>>();
		
		List<Card> first = new ArrayList<Card>();
		first.add(cardsList.get(start));
		result.add(first);
		
		while (i < cardsList.size() && cardsCount < 5) {
			
			int currentCard = cardsList.get(i).getValue();
			int prevCard = cardsList.get(i - 1).getValue();
			
			if(prevCard == currentCard + 1) {
				List<List<Card>> newAlternatives = new ArrayList<List<Card>>();
				int ii = i;
				for (List<Card> lc : result) {
					if(i < cardsList.size() - 1) {
						int n = i + 1;
						while(n < cardsList.size() && cardsList.get(n).getValue() == currentCard) {
							List<Card> newAlternative = new ArrayList<Card>();
							newAlternative.addAll(lc);
							newAlternative.add(cardsList.get(n));
							newAlternatives.add(newAlternative);
							n++;
						}
						ii = n - 1;
					}
					lc.add(cardsList.get(i));
				}
				result.addAll(newAlternatives);
				cardsCount++;
				i = ii > i ? ii : i;
			} else {
				break;
			}
			i++;
		}
		
		List<List<Card>> toRemove = new ArrayList<List<Card>>();
		List<List<Card>> withAces = new ArrayList<List<Card>>();						
		for(List<Card> cl : result) {
			if(cl.size() == 4) {
				if (cl.get(3).getValue() == 2) {
					for(Card ace : aces) {
						List<Card> newWithAces = new ArrayList<Card>();
						newWithAces.addAll(cl);
						newWithAces.add(0, ace);
						withAces.add(newWithAces);
						toRemove.add(cl);
					}
				} else 
					toRemove.add(cl);
			} else if(cl.size() < 5) {
				toRemove.add(cl);
			}
		}
		result.removeAll(toRemove);
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
			result = major1 - major2;
			if(result == 0) {
				// если флэш-стриты равны сравниваем по масти
				result = cl1.get(0).getSuit() - cl2.get(0).getSuit();
			}
		} 
		return result;
	}

	public int compareTo(Object other) {
        if (!(other instanceof Combination)) {
            throw new ClassCastException("A Combination object expected.");
        }
        
        Combination otherCombination = (Combination) other;
		int result = this.getCombinationType().val - otherCombination.getCombinationType().val;
		
        if(result != 0) {
        	return result;
        } else {
        	switch(this.getCombinationType()) {
        	case HIGH_CARD:
        		return compareHandsByOrder(this.getRestCards(), otherCombination.getRestCards());
        	case PAIR:
        		return compareHandsByOrder(this.getAllCards(), otherCombination.getAllCards());
        	case DOUBLE_PAIR:
        		return compareHandsByOrder(this.getAllCards(), otherCombination.getAllCards());
        	case TRIPLE:
        		return compareHandsByOrder(this.getAllCards(), otherCombination.getAllCards());
        	case STRAIGHT:
        		return compareStraights(this.getCards(), otherCombination.getCards());
        	case FLUSH:
        		return compareHandsByOrder(this.getAllCards(), otherCombination.getAllCards());
        	case FULL_HOUSE:
        		return compareHandsByOrder(this.getAllCards(), otherCombination.getAllCards());
        	case QUAD:
        		return compareHandsByOrder(this.getAllCards(), otherCombination.getAllCards());
        	case STRAIGHT_FLUSH:
        		return compareStraights(this.getCards(), otherCombination.getCards());
        	case FLUSH_ROYAL:
        		return compareStraights(this.getCards(), otherCombination.getCards());
        	default:
        		throw new IllegalArgumentException(String.format("Unknown CombinationType %s .", this.getCombinationType().val));
        	}
        }
	}
	
	/*
	 * Сравнивает руки от старшей карты к младшей. 
	 * Руки должны быть отсортированы по убыванию ранга карты. 
	 */
	public static int compareHandsByOrder(List<Card> cl1, List<Card> cl2) {
		int result = 0;
		if(cl1.size() != cl2.size()) {
			throw new IllegalArgumentException(String.format("List must be of one size. cl1.size = %s, cl2.size = %s", 
					cl1.size(), cl2.size()));
		}
		for(int i = 0; i < cl1.size(); i++) {
			result = cl1.get(i).getValue() - cl2.get(i).getValue();
			if(result != 0) {
				break;
			}
		}
		return result;
	}
	
}
