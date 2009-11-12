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
	
	public void testCompareStraightsEqual() {

		List<Card> straight1 = new ArrayList<Card>();
		straight1.add(new Card(3, 6));
		straight1.add(new Card(4, 5));
		straight1.add(new Card(3, 4));
		straight1.add(new Card(2, 3));
		straight1.add(new Card(4, 2));

		List<Card> straight2 = new ArrayList<Card>();
		straight2.add(new Card(3, 6));
		straight2.add(new Card(4, 5));
		straight2.add(new Card(3, 4));
		straight2.add(new Card(2, 3));
		straight2.add(new Card(4, 2));

		assertEquals(0, Combination.compareStraights(straight1, straight2));
		
	}

	public void testCompareStraightsOneWithMinorAce() {

		List<Card> straight1 = new ArrayList<Card>();
		straight1.add(new Card(3, 14));
		straight1.add(new Card(4, 5));
		straight1.add(new Card(3, 4));
		straight1.add(new Card(2, 3));
		straight1.add(new Card(4, 2));

		List<Card> straight2 = new ArrayList<Card>();
		straight2.add(new Card(3, 6));
		straight2.add(new Card(4, 5));
		straight2.add(new Card(3, 4));
		straight2.add(new Card(2, 3));
		straight2.add(new Card(4, 2));

		assertTrue(Combination.compareStraights(straight1, straight2) < 0);
		
	}	

	public void testCompareStraightsOneIsFlush() {

		List<Card> straight1 = new ArrayList<Card>();
		straight1.add(new Card(3, 7));
		straight1.add(new Card(4, 6));
		straight1.add(new Card(3, 5));
		straight1.add(new Card(2, 4));
		straight1.add(new Card(4, 3));

		List<Card> straight2 = new ArrayList<Card>();
		straight2.add(new Card(4, 6));
		straight2.add(new Card(4, 5));
		straight2.add(new Card(4, 4));
		straight2.add(new Card(4, 3));
		straight2.add(new Card(4, 2));

		assertTrue(Combination.compareStraights(straight1, straight2) < 0);
		
	}	
	
	public void testCompareStraightsTwoIsFlush() {

		List<Card> straight1 = new ArrayList<Card>();
		straight1.add(new Card(3, 6));
		straight1.add(new Card(3, 5));
		straight1.add(new Card(3, 4));
		straight1.add(new Card(3, 3));
		straight1.add(new Card(3, 2));

		List<Card> straight2 = new ArrayList<Card>();
		straight2.add(new Card(4, 6));
		straight2.add(new Card(4, 5));
		straight2.add(new Card(4, 4));
		straight2.add(new Card(4, 3));
		straight2.add(new Card(4, 2));

		assertTrue(Combination.compareStraights(straight2, straight1) > 0);
		
	}	
	
	public void testCompareStraightsFlushAndRoyal() {

		List<Card> straight1 = new ArrayList<Card>();
		straight1.add(new Card(3, 14));
		straight1.add(new Card(3, 13));
		straight1.add(new Card(3, 12));
		straight1.add(new Card(3, 11));
		straight1.add(new Card(3, 10));

		List<Card> straight2 = new ArrayList<Card>();
		straight2.add(new Card(4, 6));
		straight2.add(new Card(4, 5));
		straight2.add(new Card(4, 4));
		straight2.add(new Card(4, 3));
		straight2.add(new Card(4, 2));

		assertTrue(Combination.compareStraights(straight1, straight2) > 0);
		
	}	
	
	public void testCompareStraightsTwoRoyals() {

		List<Card> straight1 = new ArrayList<Card>();
		straight1.add(new Card(3, 14));
		straight1.add(new Card(3, 13));
		straight1.add(new Card(3, 12));
		straight1.add(new Card(3, 11));
		straight1.add(new Card(3, 10));

		List<Card> straight2 = new ArrayList<Card>();
		straight2.add(new Card(4, 14));
		straight2.add(new Card(4, 13));
		straight2.add(new Card(4, 12));
		straight2.add(new Card(4, 11));
		straight2.add(new Card(4, 10));

		assertTrue(Combination.compareStraights(straight1, straight2) < 0);
		
	}	

	public void testCompareStraightsOneIsRoyal() {

		List<Card> straight1 = new ArrayList<Card>();
		straight1.add(new Card(3, 14));
		straight1.add(new Card(3, 13));
		straight1.add(new Card(3, 12));
		straight1.add(new Card(3, 11));
		straight1.add(new Card(3, 10));

		List<Card> straight2 = new ArrayList<Card>();
		straight2.add(new Card(2, 14));
		straight2.add(new Card(3, 13));
		straight2.add(new Card(4, 12));
		straight2.add(new Card(1, 11));
		straight2.add(new Card(2, 10));

		assertTrue(Combination.compareStraights(straight1, straight2) > 0);
		
	}	
	
	public void testCompareHandsByOrder() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(3, 13));
		cards_list1.add(new Card(3, 11));
		cards_list1.add(new Card(3, 3));
		cards_list1.add(new Card(3, 2));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 13));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(1, 4));
		cards_list2.add(new Card(2, 3));

		assertTrue(Combination.compareHandsByOrder(cards_list1, cards_list2) < 0);
		
	}	

	public void testCompareHandsByOrder2() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(3, 13));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(3, 3));
		cards_list1.add(new Card(3, 2));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 13));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(1, 3));
		cards_list2.add(new Card(2, 3));

		assertTrue(Combination.compareHandsByOrder(cards_list1, cards_list2) < 0);
		
	}	
	
	public void testCompareHandsByOrderEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(3, 13));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(3, 3));
		cards_list1.add(new Card(3, 3));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 13));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(1, 3));
		cards_list2.add(new Card(2, 3));

		assertEquals(0, Combination.compareHandsByOrder(cards_list1, cards_list2));
		
	}	
	private void assertCardsArrays(List<Card> cards1, List<Card> cards2) {
		assertEquals(cards1.size(), cards2.size());
		for (int i = 0; i < cards1.size(); i++) {
			// println "${cards1.get(i)} ${cards2.get(i)}"
			assertEquals(cards1.get(i), cards2.get(i));
		}
	}

}
