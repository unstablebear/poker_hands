package com.zl.poker;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class CombinationTest extends TestCase {

	public CombinationTest(String testName) {
		super(testName);
	}

	public void testGetStraightAtPositionNoStraight() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(4, 6));
		cards.add(new Card(4, 5));
		cards.add(new Card(3, 4));
		cards.add(new Card(4, 7));
		cards.add(new Card(3, 2));
		cards.add(new Card(1, 2));

		List<List<Card>> exp_list = Combination.getStraightAtPosition(cards, 0,
				new ArrayList<Card>());
		assertEquals(0, exp_list.size());

	}
	
	public void testGetStraightAtPositionExact() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(4, 6));
		cards.add(new Card(4, 5));
		cards.add(new Card(3, 4));
		cards.add(new Card(4, 3));
		cards.add(new Card(3, 2));

		List<Card> cards_exp1 = new ArrayList<Card>();
		cards_exp1.add(new Card(4, 6));
		cards_exp1.add(new Card(4, 5));
		cards_exp1.add(new Card(3, 4));
		cards_exp1.add(new Card(4, 3));
		cards_exp1.add(new Card(3, 2));
		
		List<List<Card>> exp_list = Combination.getStraightAtPosition(cards, 0,
				new ArrayList<Card>());
		assertEquals(1, exp_list.size());
		assertCardsArrays(cards_exp1, exp_list.get(0));

	}
	
	public void testGetStraightAtPositionWithTailPair() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(4, 6));
		cards.add(new Card(4, 5));
		cards.add(new Card(3, 4));
		cards.add(new Card(4, 3));
		cards.add(new Card(3, 2));
		cards.add(new Card(1, 2));

		List<Card> cards_exp1 = new ArrayList<Card>();
		cards_exp1.add(new Card(4, 6));
		cards_exp1.add(new Card(4, 5));
		cards_exp1.add(new Card(3, 4));
		cards_exp1.add(new Card(4, 3));
		cards_exp1.add(new Card(3, 2));

		List<Card> cards_exp2 = new ArrayList<Card>();
		cards_exp2.add(new Card(4, 6));
		cards_exp2.add(new Card(4, 5));
		cards_exp2.add(new Card(3, 4));
		cards_exp2.add(new Card(4, 3));
		cards_exp2.add(new Card(1, 2));
		
		
		List<List<Card>> exp_list = Combination.getStraightAtPosition(cards, 0,
				new ArrayList<Card>());
		
		assertEquals(2, exp_list.size());
		assertCardsArrays(cards_exp1, exp_list.get(0));
		assertCardsArrays(cards_exp2, exp_list.get(1));

	}

	public void testGetStraightAtPositionWithTailTriple() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(4, 6));
		cards.add(new Card(4, 5));
		cards.add(new Card(3, 4));
		cards.add(new Card(4, 3));
		cards.add(new Card(3, 2));
		cards.add(new Card(2, 2));
		cards.add(new Card(1, 2));

		List<Card> cards_exp1 = new ArrayList<Card>();
		cards_exp1.add(new Card(4, 6));
		cards_exp1.add(new Card(4, 5));
		cards_exp1.add(new Card(3, 4));
		cards_exp1.add(new Card(4, 3));
		cards_exp1.add(new Card(3, 2));

		List<Card> cards_exp2 = new ArrayList<Card>();
		cards_exp2.add(new Card(4, 6));
		cards_exp2.add(new Card(4, 5));
		cards_exp2.add(new Card(3, 4));
		cards_exp2.add(new Card(4, 3));
		cards_exp2.add(new Card(2, 2));
		
		List<Card> cards_exp3 = new ArrayList<Card>();
		cards_exp3.add(new Card(4, 6));
		cards_exp3.add(new Card(4, 5));
		cards_exp3.add(new Card(3, 4));
		cards_exp3.add(new Card(4, 3));
		cards_exp3.add(new Card(1, 2));
		
		List<List<Card>> exp_list = Combination.getStraightAtPosition(cards, 0,
				new ArrayList<Card>());
		
		assertEquals(3, exp_list.size());
		assertCardsArrays(cards_exp1, exp_list.get(0));
		assertCardsArrays(cards_exp2, exp_list.get(1));
		assertCardsArrays(cards_exp3, exp_list.get(2));

	}	
	
	public void testGetStraightAtPositionWithMiddleTriple() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(4, 6));
		cards.add(new Card(4, 5));
		cards.add(new Card(3, 4));
		cards.add(new Card(4, 3));
		cards.add(new Card(3, 3));
		cards.add(new Card(2, 3));
		cards.add(new Card(1, 2));

		List<Card> cards_exp1 = new ArrayList<Card>();
		cards_exp1.add(new Card(4, 6));
		cards_exp1.add(new Card(4, 5));
		cards_exp1.add(new Card(3, 4));
		cards_exp1.add(new Card(4, 3));
		cards_exp1.add(new Card(1, 2));

		List<Card> cards_exp2 = new ArrayList<Card>();
		cards_exp2.add(new Card(4, 6));
		cards_exp2.add(new Card(4, 5));
		cards_exp2.add(new Card(3, 4));
		cards_exp2.add(new Card(3, 3));
		cards_exp2.add(new Card(1, 2));
		
		List<Card> cards_exp3 = new ArrayList<Card>();
		cards_exp3.add(new Card(4, 6));
		cards_exp3.add(new Card(4, 5));
		cards_exp3.add(new Card(3, 4));
		cards_exp3.add(new Card(2, 3));
		cards_exp3.add(new Card(1, 2));
		
		List<List<Card>> exp_list = Combination.getStraightAtPosition(cards, 0,
				new ArrayList<Card>());
		
		assertEquals(3, exp_list.size());
		assertCardsArrays(cards_exp1, exp_list.get(0));
		assertCardsArrays(cards_exp2, exp_list.get(1));
		assertCardsArrays(cards_exp3, exp_list.get(2));

	}	

	public void testGetStraightAtPositionWithTwoPairs() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(4, 6));
		cards.add(new Card(4, 5));
		cards.add(new Card(4, 4));
		cards.add(new Card(3, 4));
		cards.add(new Card(3, 3));
		cards.add(new Card(2, 3));
		cards.add(new Card(1, 2));
		
		List<Card> cards_exp1 = new ArrayList<Card>();
		cards_exp1.add(new Card(4, 6));
		cards_exp1.add(new Card(4, 5));
		cards_exp1.add(new Card(4, 4));
		cards_exp1.add(new Card(3, 3));
		cards_exp1.add(new Card(1, 2));

		List<Card> cards_exp2 = new ArrayList<Card>();
		cards_exp2.add(new Card(4, 6));
		cards_exp2.add(new Card(4, 5));
		cards_exp2.add(new Card(3, 4));
		cards_exp2.add(new Card(3, 3));
		cards_exp2.add(new Card(1, 2));

		List<Card> cards_exp3 = new ArrayList<Card>();
		cards_exp3.add(new Card(4, 6));
		cards_exp3.add(new Card(4, 5));
		cards_exp3.add(new Card(4, 4));
		cards_exp3.add(new Card(2, 3));
		cards_exp3.add(new Card(1, 2));

		List<Card> cards_exp4 = new ArrayList<Card>();
		cards_exp4.add(new Card(4, 6));
		cards_exp4.add(new Card(4, 5));
		cards_exp4.add(new Card(3, 4));
		cards_exp4.add(new Card(2, 3));
		cards_exp4.add(new Card(1, 2));
		
		List<List<Card>> exp_list = Combination.getStraightAtPosition(cards, 0,
				new ArrayList<Card>());
		
		assertEquals(4, exp_list.size());
		assertCardsArrays(cards_exp1, exp_list.get(0));
		assertCardsArrays(cards_exp2, exp_list.get(1));
		assertCardsArrays(cards_exp3, exp_list.get(2));
		assertCardsArrays(cards_exp4, exp_list.get(3));

	}	
	
	public void testGetStraightAtPositionWithTwoFarPairs() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(4, 6));
		cards.add(new Card(4, 5));
		cards.add(new Card(3, 5));
		cards.add(new Card(3, 4));
		cards.add(new Card(3, 3));
		cards.add(new Card(2, 3));
		cards.add(new Card(1, 2));
		
		List<Card> cards_exp1 = new ArrayList<Card>();
		cards_exp1.add(new Card(4, 6));
		cards_exp1.add(new Card(4, 5));
		cards_exp1.add(new Card(3, 4));
		cards_exp1.add(new Card(3, 3));
		cards_exp1.add(new Card(1, 2));

		List<Card> cards_exp2 = new ArrayList<Card>();
		cards_exp2.add(new Card(4, 6));
		cards_exp2.add(new Card(3, 5));
		cards_exp2.add(new Card(3, 4));
		cards_exp2.add(new Card(3, 3));
		cards_exp2.add(new Card(1, 2));

		List<Card> cards_exp3 = new ArrayList<Card>();
		cards_exp3.add(new Card(4, 6));
		cards_exp3.add(new Card(4, 5));
		cards_exp3.add(new Card(3, 4));
		cards_exp3.add(new Card(2, 3));
		cards_exp3.add(new Card(1, 2));

		List<Card> cards_exp4 = new ArrayList<Card>();
		cards_exp4.add(new Card(4, 6));
		cards_exp4.add(new Card(3, 5));
		cards_exp4.add(new Card(3, 4));
		cards_exp4.add(new Card(2, 3));
		cards_exp4.add(new Card(1, 2));
		
		List<List<Card>> exp_list = Combination.getStraightAtPosition(cards, 0,
				new ArrayList<Card>());
		
		assertEquals(4, exp_list.size());
		assertCardsArrays(cards_exp1, exp_list.get(0));
		assertCardsArrays(cards_exp2, exp_list.get(1));
		assertCardsArrays(cards_exp3, exp_list.get(2));
		assertCardsArrays(cards_exp4, exp_list.get(3));

	}	
	
	public void testGetStraightAtPositionWithAce() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(4, 7));
		cards.add(new Card(4, 5));
		cards.add(new Card(3, 4));
		cards.add(new Card(4, 3));
		cards.add(new Card(3, 2));

		List<Card> aces = new ArrayList<Card>();
		aces.add(new Card(4, 14));
		aces.add(new Card(3, 14));
		
		List<Card> cards_exp1 = new ArrayList<Card>();
		cards_exp1.add(new Card(4, 14));
		cards_exp1.add(new Card(4, 5));
		cards_exp1.add(new Card(3, 4));
		cards_exp1.add(new Card(4, 3));
		cards_exp1.add(new Card(3, 2));

		List<Card> cards_exp2 = new ArrayList<Card>();
		cards_exp2.add(new Card(3, 14));
		cards_exp2.add(new Card(4, 5));
		cards_exp2.add(new Card(3, 4));
		cards_exp2.add(new Card(4, 3));
		cards_exp2.add(new Card(3, 2));
		
		List<List<Card>> exp_list = Combination.getStraightAtPosition(cards, 0, aces);
		assertEquals(2, exp_list.size());
		assertCardsArrays(cards_exp1, exp_list.get(0));
		assertCardsArrays(cards_exp2, exp_list.get(1));

	}

	public void testGetStraightAtPositionWithAceAndPair() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(4, 5));
		cards.add(new Card(3, 4));
		cards.add(new Card(2, 4));
		cards.add(new Card(4, 3));
		cards.add(new Card(3, 2));

		List<Card> aces = new ArrayList<Card>();
		aces.add(new Card(4, 14));
		aces.add(new Card(3, 14));
		
		List<Card> cards_exp1 = new ArrayList<Card>();
		cards_exp1.add(new Card(4, 14));
		cards_exp1.add(new Card(4, 5));
		cards_exp1.add(new Card(3, 4));
		cards_exp1.add(new Card(4, 3));
		cards_exp1.add(new Card(3, 2));

		List<Card> cards_exp2 = new ArrayList<Card>();
		cards_exp2.add(new Card(4, 14));
		cards_exp2.add(new Card(4, 5));
		cards_exp2.add(new Card(2, 4));
		cards_exp2.add(new Card(4, 3));
		cards_exp2.add(new Card(3, 2));

		List<Card> cards_exp3 = new ArrayList<Card>();
		cards_exp3.add(new Card(3, 14));
		cards_exp3.add(new Card(4, 5));
		cards_exp3.add(new Card(3, 4));
		cards_exp3.add(new Card(4, 3));
		cards_exp3.add(new Card(3, 2));

		List<Card> cards_exp4 = new ArrayList<Card>();
		cards_exp4.add(new Card(3, 14));
		cards_exp4.add(new Card(4, 5));
		cards_exp4.add(new Card(2, 4));
		cards_exp4.add(new Card(4, 3));
		cards_exp4.add(new Card(3, 2));
		
		List<List<Card>> exp_list = Combination.getStraightAtPosition(cards, 0, aces);
		assertEquals(4, exp_list.size());
		assertCardsArrays(cards_exp1, exp_list.get(0));
		assertCardsArrays(cards_exp2, exp_list.get(1));
		assertCardsArrays(cards_exp3, exp_list.get(2));
		assertCardsArrays(cards_exp4, exp_list.get(3));
		

	}	
	
	private void assertCardsArrays(List<Card> cards1, List<Card> cards2) {
		assertEquals(cards1.size(), cards2.size());
		for (int i = 0; i < cards1.size(); i++) {
			// println "${cards1.get(i)} ${cards2.get(i)}"
			assertEquals(cards1.get(i), cards2.get(i));
		}
	}

}
