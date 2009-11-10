package com.zl.poker;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Combination {
    
    private List<Card> cards = new ArrayList<Card>();
    private List<Card> restCards = new ArrayList<Card>();
    
    private int combinationType = 0;

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
	    combinationType = 5;
	} else if(triples_cnt == 1) {
            combinationType = 3;
        } else if(pairs_cnt == 1) {
            combinationType = 1;
        } else if (pairs_cnt == 2) {
            combinationType = 2;
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
                combinationType = 4;
            }
        }
	//	System.out.println("CombinationType = " + combinationType);
	if(combinationType == 0) {
	    for(int i = 0; i < flash.length; i++) {
		//		System.out.println("flash = " + flash[i]);
		if(flash[i] > 3)
		{
		    combinationType = 6;		
		    for(int j = 0; j < cardsSet.size(); j++) {
			if(cardsSet.get(j).getSuit() == flash[i]) {
			    cards.add(cardsSet.get(j));			
			}
		    }
		    break;
		}    
	    }
	}

        if(combinationType > 0) {
            for(int j = 0; j < cardsSet.size(); j++) {
                if(!cards.contains(cardsSet.get(j))) {
                    restCards.add(cardsSet.get(j));
                }
            }
        }
	Collections.sort(cards);
	Collections.sort(restCards);
    }

    public int getCombinationType() {
        return this.combinationType;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public List<Card> getRestCards() {
        return this.restCards;
    }

}
