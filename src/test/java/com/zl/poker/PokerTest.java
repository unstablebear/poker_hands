package com.zl.poker;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;
import java.util.ArrayList;

public class PokerTest extends TestCase {

    Poker testable = new Poker();

    public PokerTest( String testName )
    {
        super( testName );
    }
    

    public void testSortCards() {

        Poker testable = new Poker();

        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(4, 2));
        cards.add(new Card(3, 2));
        cards.add(new Card(4, 3));
        cards.add(new Card(4, 8));
        cards.add(new Card(3, 6));
        cards.add(new Card(1, 2));

        List<Card> cards_sorted = new ArrayList<Card>();
        cards_sorted.add(new Card(4, 8));
        cards_sorted.add(new Card(3, 6));
        cards_sorted.add(new Card(4, 3));
        cards_sorted.add(new Card(4, 2));
        cards_sorted.add(new Card(3, 2));
        cards_sorted.add(new Card(1, 2));

        testable.sortCards(cards);

        assertCardsArrays(cards, cards_sorted);

    }
    
    public void testGetCombinationPair() {

        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, 2));
        cards.add(new Card(4, 3));
        cards.add(new Card(4, 8));
        cards.add(new Card(3, 5));
        cards.add(new Card(3, 6));
        cards.add(new Card(4, 2));

        Combination combination = testable.getCombination(cards);
        
        List<Card> cards_exp = new ArrayList<Card>();
        cards_exp.add(new Card(4, 2));
        cards_exp.add(new Card(1, 2)); 

        List<Card> rest_cards_exp = new ArrayList<Card>();
        rest_cards_exp.add(new Card(4, 8));
        rest_cards_exp.add(new Card(3, 6)); 
        rest_cards_exp.add(new Card(3, 5)); 
        rest_cards_exp.add(new Card(4, 3)); 

        assertEquals(1, combination.getCombinationType());
        assertCardsArrays(cards_exp, combination.getCards());
        assertCardsArrays(rest_cards_exp, combination.getRestCards());

    }

    public void testGetCombinationDoublePair() {

        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(4, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(4, 8));
        cards.add(new Card(4, 3));
        cards.add(new Card(3, 6));
        cards.add(new Card(1, 2));

        Combination combination = testable.getCombination(cards);
        
        List<Card> cards_exp = new ArrayList<Card>();
        cards_exp.add(new Card(4, 3));
        cards_exp.add(new Card(3, 3)); 
        cards_exp.add(new Card(4, 2));
        cards_exp.add(new Card(1, 2)); 
        
        List<Card> rest_cards_exp = new ArrayList<Card>();
        rest_cards_exp.add(new Card(4, 8));
        rest_cards_exp.add(new Card(3, 6)); 

        assertEquals(2, combination.getCombinationType());
        assertCardsArrays(cards_exp, combination.getCards());
        assertCardsArrays(rest_cards_exp, combination.getRestCards());
    }

    public void testGetCombinationTriple() {

        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(4, 2));
        cards.add(new Card(3, 3));
        cards.add(new Card(4, 8));
        cards.add(new Card(4, 3));
        cards.add(new Card(3, 6));
        cards.add(new Card(1, 3));

        Combination combination = testable.getCombination(cards);
        
        List<Card> cards_exp = new ArrayList<Card>();
        cards_exp.add(new Card(4, 3));
        cards_exp.add(new Card(3, 3)); 
        cards_exp.add(new Card(1, 3)); 

        List<Card> rest_cards_exp = new ArrayList<Card>();
        rest_cards_exp.add(new Card(4, 8));
        rest_cards_exp.add(new Card(3, 6));
        rest_cards_exp.add(new Card(4, 2));
        
        assertEquals(3, combination.getCombinationType());
        assertCardsArrays(cards_exp, combination.getCards());
        assertCardsArrays(rest_cards_exp, combination.getRestCards());
    }

    public void testGetCombinationStraight() {

        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(4, 4));
        cards.add(new Card(4, 6));
        cards.add(new Card(3, 2));
        cards.add(new Card(3, 5));
        cards.add(new Card(4, 3));
        cards.add(new Card(1, 11));

        Combination combination = testable.getCombination(cards);
        
        List<Card> cards_exp = new ArrayList<Card>();
        cards_exp.add(new Card(4, 6));
        cards_exp.add(new Card(3, 5)); 
        cards_exp.add(new Card(4, 4)); 
        cards_exp.add(new Card(4, 3));
        cards_exp.add(new Card(3, 2)); 

        List<Card> rest_cards_exp = new ArrayList<Card>();
        rest_cards_exp.add(new Card(1, 11)); 
        
        assertEquals(4, combination.getCombinationType());
        assertCardsArrays(cards_exp, combination.getCards());
        assertCardsArrays(rest_cards_exp, combination.getRestCards());
    }

    public void testGetCombinationStraightWithMinorA() {

        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(4, 4));
        cards.add(new Card(4, 3));
        cards.add(new Card(3, 7));
        cards.add(new Card(3, 5));
        cards.add(new Card(4, 2));
        cards.add(new Card(1, 14));

        Combination combination = testable.getCombination(cards);
        
        List<Card> cards_exp = new ArrayList<Card>();
        cards_exp.add(new Card(1, 14));
        cards_exp.add(new Card(3, 5)); 
        cards_exp.add(new Card(4, 4)); 
        cards_exp.add(new Card(4, 3));
        cards_exp.add(new Card(4, 2)); 

        List<Card> rest_cards_exp = new ArrayList<Card>();
        rest_cards_exp.add(new Card(3, 7)); 
        
        assertEquals(4, combination.getCombinationType());
        assertCardsArrays(cards_exp, combination.getCards());
        assertCardsArrays(rest_cards_exp, combination.getRestCards());

    }

    public void testGetCombinationQuad() {

        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(2, 7));
        cards.add(new Card(4, 7));
        cards.add(new Card(3, 8));
        cards.add(new Card(3, 7));
        cards.add(new Card(4, 2));
        cards.add(new Card(1, 7));

        Combination combination = testable.getCombination(cards);
        
        List<Card> cards_exp = new ArrayList<Card>();
        cards_exp.add(new Card(4, 7));
        cards_exp.add(new Card(3, 7)); 
        cards_exp.add(new Card(2, 7)); 
        cards_exp.add(new Card(1, 7));

        List<Card> rest_cards_exp = new ArrayList<Card>();
        rest_cards_exp.add(new Card(3, 8));
        rest_cards_exp.add(new Card(4, 2));
        
        assertEquals(5, combination.getCombinationType());
        assertCardsArrays(cards_exp, combination.getCards());
        assertCardsArrays(rest_cards_exp, combination.getRestCards());

    }

    public void testGetCombinationFlash() {

        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(4, 4));
        cards.add(new Card(4, 3));
        cards.add(new Card(3, 8));
        cards.add(new Card(4, 7));
        cards.add(new Card(4, 2));
        cards.add(new Card(4, 6));

        Combination combination = testable.getCombination(cards);
        
        List<Card> cards_exp = new ArrayList<Card>();
        cards_exp.add(new Card(4, 7));
        cards_exp.add(new Card(4, 6)); 
        cards_exp.add(new Card(4, 4)); 
        cards_exp.add(new Card(4, 3));
        cards_exp.add(new Card(4, 2));

        List<Card> rest_cards_exp = new ArrayList<Card>();
        rest_cards_exp.add(new Card(3, 8));
        
        assertEquals(6, combination.getCombinationType());
        assertCardsArrays(cards_exp, combination.getCards());
        assertCardsArrays(rest_cards_exp, combination.getRestCards());

    }

    private void assertCardsArrays(List<Card> cards1, List<Card> cards2) {
        assertEquals(cards1.size(), cards2.size());
        for(int i = 0; i < cards1.size(); i ++) {
//            println "${cards1.get(i)} ${cards2.get(i)}"
            assertEquals(cards1.get(i), cards2.get(i));
        }
    }

}


