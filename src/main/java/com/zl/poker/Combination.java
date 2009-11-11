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

    public Combination(List<Card> cardsSet)
    {

	//	System.out.println("<>");
        int pairs_cnt = 0;
        int triples_cnt = 0;
	int quad_cnt = 0;
        int[] pairs = new int[15];
	int[] flash = new int[5];

        for(int i = 0; i < cardsSet.size(); i++) {
	    boolean isFlashExists = flash[cardsSet.get(i).getSuit()] > 0;
	    if(pairs[cardsSet.get(i).getValue()] == 0) {
		for(int j = i + 1; j < cardsSet.size(); j++) {
                    if(cardsSet.get(i).getValue() == cardsSet.get(j).getValue()) {
			//System.out.println("! " + cardsSet.get(i).getValue() + " " + cardsSet.get(j).getValue());
                        pairs[cardsSet.get(i).getValue()]++; 
                    }
		    if(!isFlashExists && cardsSet.get(i).getSuit() == cardsSet.get(j).getSuit()) {
			//System.out.println("! " + cardsSet.get(i).getSuit() + " " + cardsSet.get(j).getSuit());
                        //pairs[cardsSet.get(i).getValue()]++; 
			flash[cardsSet.get(i).getSuit()]++;
			//System.out.println("flash_cnt = " + flash[cardsSet.get(i).getSuit()]);
                    }
                }
            }
        }

        for(int i = 2; i < 15; i++) {
	    //System.out.println("? " + pairs[i] + " " + i);
            switch(pairs[i]) {
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
            for(int j = 0; j < cardsSet.size(); j++) {
                if(cardsSet.get(j).getValue() == i) {
                    cards.add(cardsSet.get(j));
                }
            }
            if(triples_cnt > 0)
		break;
        }


        if(quad_cnt == 1) {
	    combinationType = CombinationType.QUAD;
	} else if(triples_cnt == 1) {
            combinationType = CombinationType.TRIPLE;
        } else if(pairs_cnt == 1) {
            combinationType = CombinationType.PAIR;
        } else if (pairs_cnt == 2) {
            combinationType = CombinationType.DOUBLE_PAIR;
        } else {
            Collections.sort(cardsSet);
            boolean isStraight = true;
            int straightPosition = -1;
            int edge = 5;
            if(cardsSet.get(0).getValue() == 14) {
                edge = 4;
            }
            for(int i = 0; i < cardsSet.size() - (edge - 1); i++) {

                for(int j = i + 1; j < i + edge; j++)
                {
                    int k1 = cardsSet.get(j - 1).getValue();
		    int k2 = cardsSet.get(j).getValue();
                    //                    println ">> ${cardsSet.get(j - 1).getValue()} ${(cardsSet.get(j).getValue() + 1)} "
                    if(k1 != (k2 + 1) && !(cardsSet.get(0).getValue() == 14 && cardsSet.get(i).getValue() != 14 && k2 == 2 && j == i + 4))
                    {
//                        println "$k1 $k2 ?2 ${cardsSet.get(0).getValue()} ${cardsSet.get(i).getValue()} != 14 $j ${i + 4}"
                        isStraight = false;
                        break;
                    } else {
                        //println "?3"
                        if(k2 == 2) {
                            isStraight = true;
                        }
                    }
                    //println "1????"
                }
                if(isStraight) {
                    //println "!!!!"
                    straightPosition = i;
                    break;
                }
                //println "????"
            }
            if (isStraight) {
                for(int i = 0; i < cardsSet.size(); i++) {
                    //println "> ${cardsSet.get(i)} > $straightPosition"
                    if(i >= straightPosition && i < straightPosition + 5) {
                        cards.add(cardsSet.get(i));
                    }
                }
                if(edge == 4 && cardsSet.get(straightPosition + (edge - 1)).getValue() == 2)
                  cards.add(cardsSet.get(0));
                combinationType = CombinationType.STRAIGHT;
            }
        }

	// проверка на full house
	if(combinationType.val > 0 && combinationType.val < CombinationType.FULL_HOUSE.val && pairs_cnt > 0 && triples_cnt > 0) {
	    combinationType = CombinationType.FULL_HOUSE;
	}
	
	//	System.out.println("CombinationType = " + combinationType);
	if(combinationType.equals(CombinationType.HIGH_CARD)) {
	    for(int i = 0; i < flash.length; i++) {
		//		System.out.println("flash = " + flash[i]);
		if(flash[i] > 3)
		{
		    combinationType = CombinationType.FLUSH;		
		    for(int j = 0; j < cardsSet.size(); j++) {
			if(cardsSet.get(j).getSuit() == flash[i]) {
			    cards.add(cardsSet.get(j));			
			}
		    }
		    break;
		}    
	    }
	} else if (combinationType.equals(CombinationType.STRAIGHT)) {
	    System.out.println("###");
	    if(checkForFlush(cards, 0)) {
		combinationType = CombinationType.STRAIGHT_FLUSH;
	    }
	}

        if(combinationType.val > CombinationType.HIGH_CARD.val) {
            for(int j = 0; j < cardsSet.size(); j++) {
                if(!cards.contains(cardsSet.get(j))) {
                    restCards.add(cardsSet.get(j));
                }
            }
        }
	Collections.sort(cards);
	Collections.sort(restCards);
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

    private boolean checkForFlush(List<Card> cardsList, int start) {
	if(start < 0 || cardsList.size() - start < 5) {
	    throw new IllegalArgumentException(String.format("start index = %s ; cards list size = %s", start, cardsList.size()));
	}
	for(int i = start + 1; i < start + 5; i++) {
	    System.out.println("CheckForFlush : " + cardsList.get(i - 1).getSuit() + " " + cardsList.get(i).getSuit());
	    if(cardsList.get(i - 1).getSuit() != cardsList.get(i).getSuit()) {
		return false;
	    }
	}
	return true;
    }

    /*    private List<List<Card>> getAllStraigths(List<Card> cardsList) {
	List<List<Card>> result = new ArrayList<List<Card>>();

	Collections.sort(cardsList);

	boolean isAceExists = cardsList.get(0).getValue() == 14;
	for(int i = 0; i < cardsList.size() - 5; i++) {
	    	    if (checkForStraight(cardsList, i, isAceExists)) {
		
		    }
	}

	return
    }*/

    public static List<List<Card>> getStraightAtPosition(List<Card> cardsList, int start, boolean isAceExists) {
	if(start > cardsList.size() - 5 || start < 0) {
	    throw new IllegalArgumentException(String.format("start index = %s ; cards list size = %s", start, cardsList.size()));
	}
	boolean isStraight = false;
	List<List<Card>> result = new ArrayList<List<Card>>();
	List<Card> cl = new ArrayList<Card>();
	result.add(cl);
	int i = start;

	while(i < start + 4) {
	    int card1 = cardsList.get(i).getValue();
	    int card2 = cardsList.get(i + 1).getValue();

	    boolean isCurrentMoreByOneThanNext = card1 == card2 + 1;
	    boolean isStraightHasMinorAce = isAceExists && card2 == 2 && i == start + 4;
	    boolean isCurrentEqualsNext = card1 == card2;
	    boolean isCurrentCardHasMoreThanOneFollowing = cardsList.size() > i + 1;

	    if(isCurrentMoreByOneThanNext || isStraightHasMinorAce || (isCurrentEqualsNext))
	    {
		List<List<Card>> newAlternatives = new ArrayList<List<Card>>();
		for(List<Card> lc : result) {
		    if(card1 == card2) { // two equal values cards 

			List<Card> newAlternative = new ArrayList<Card>();
			newAlternative.addAll(lc);

			lc.add(cardsList.get(i));

			newAlternative.add(cardsList.get(i + 1));
			newAlternatives.add(newAlternative);

			start++;
			i++;
		    } else {
			lc.add(cardsList.get(i));
		    }
		}
		result.addAll(newAlternatives);
		isStraight = true;
	    } else {
		isStraight = false;
		break;
	    }
	}
	return result;
    }

}
