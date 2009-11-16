package com.zl.poker;

import java.util.ArrayList;
import java.util.List;
import com.zl.poker.Card;

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
		
		List<List<Card>> exp_list = Combination.getStraightAtPosition(cards, 1, aces);
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
		cards_exp2.add(new Card(3, 14));
		cards_exp2.add(new Card(4, 5));
		cards_exp2.add(new Card(3, 4));
		cards_exp2.add(new Card(4, 3));
		cards_exp2.add(new Card(3, 2));

		List<Card> cards_exp3 = new ArrayList<Card>();
		cards_exp3.add(new Card(4, 14));
		cards_exp3.add(new Card(4, 5));
		cards_exp3.add(new Card(2, 4));
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
	
	public void testCompareStraightsTwoFlushes() {

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

	public void testCompareCombinationsHighCardsNotEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(2, 14));
		cards_list1.add(new Card(3, 13));
		cards_list1.add(new Card(4, 12));
		cards_list1.add(new Card(1, 3));
		cards_list1.add(new Card(2, 2));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 13));
		cards_list2.add(new Card(4, 11));
		cards_list2.add(new Card(1, 3));
		cards_list2.add(new Card(2, 2));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);
		
		assertEquals(CombinationType.HIGH_CARD, c1.getCombinationType());
		assertEquals(CombinationType.HIGH_CARD, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) > 0);
		
	}	
	
	public void testCompareCombinationsPairsNotEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(2, 11));
		cards_list1.add(new Card(3, 11));
		cards_list1.add(new Card(3, 3));
		cards_list1.add(new Card(3, 2));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 12));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(1, 3));
		cards_list2.add(new Card(2, 2));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);
		
		assertEquals(CombinationType.PAIR, c1.getCombinationType());
		assertEquals(CombinationType.PAIR, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) < 0);
		
	}	

	public void testCompareCombinationsTwoPairsNotEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(2, 12));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(3, 3));
		cards_list1.add(new Card(3, 3));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 12));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(1, 2));
		cards_list2.add(new Card(2, 2));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);
		
		assertEquals(CombinationType.DOUBLE_PAIR, c1.getCombinationType());
		assertEquals(CombinationType.DOUBLE_PAIR, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) > 0);
	}
	
	public void testCompareCombinationsTripletsNotEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(3, 11));
		cards_list1.add(new Card(2, 11));
		cards_list1.add(new Card(1, 11));
		cards_list1.add(new Card(3, 3));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 12));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(1, 12));
		cards_list2.add(new Card(2, 3));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);
		
		assertEquals(CombinationType.TRIPLE, c1.getCombinationType());
		assertEquals(CombinationType.TRIPLE, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) < 0);
		
	}	
	
	public void testCompareCombinationsStraightNotEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(4, 13));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(2, 11));
		cards_list1.add(new Card(3, 10));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(3, 14));
		cards_list2.add(new Card(4, 5));
		cards_list2.add(new Card(3, 4));
		cards_list2.add(new Card(2, 3));
		cards_list2.add(new Card(3, 2));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);
		
		assertEquals(CombinationType.STRAIGHT, c1.getCombinationType());
		assertEquals(CombinationType.STRAIGHT, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) > 0);
		
	}	
	
	public void testCompareCombinationsFlushesNotEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(2, 12));
		cards_list1.add(new Card(2, 11));
		cards_list1.add(new Card(2, 10));
		cards_list1.add(new Card(2, 9));
		cards_list1.add(new Card(2, 7));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(3, 13));
		cards_list2.add(new Card(3, 12));
		cards_list2.add(new Card(3, 11));
		cards_list2.add(new Card(3, 10));
		cards_list2.add(new Card(3, 7));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.FLUSH, c1.getCombinationType());
		assertEquals(CombinationType.FLUSH, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) < 0);
		
	}
	
	public void testCompareCombinationsFullHouseNotEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(2, 14));
		cards_list1.add(new Card(4, 14));
		cards_list1.add(new Card(2, 10));
		cards_list1.add(new Card(1, 10));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(3, 14));
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 14));
		cards_list2.add(new Card(3, 9));
		cards_list2.add(new Card(3, 9));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.FULL_HOUSE, c1.getCombinationType());
		assertEquals(CombinationType.FULL_HOUSE, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) > 0);
		
	}
	
	public void testCompareCombinationsQuadsNotEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(4, 11));
		cards_list1.add(new Card(3, 11));
		cards_list1.add(new Card(2, 11));
		cards_list1.add(new Card(1, 11));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(3, 12));
		cards_list2.add(new Card(2, 12));
		cards_list2.add(new Card(1, 12));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);
		
		assertEquals(CombinationType.QUAD, c1.getCombinationType());
		assertEquals(CombinationType.QUAD, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) < 0);
		
	}

	public void testCompareCombinationsStraightFlushNotEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(4, 13));
		cards_list1.add(new Card(4, 12));
		cards_list1.add(new Card(4, 11));
		cards_list1.add(new Card(4, 10));
		cards_list1.add(new Card(4, 9));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 11));
		cards_list2.add(new Card(4, 10));
		cards_list2.add(new Card(4, 9));
		cards_list2.add(new Card(4, 8));
		cards_list2.add(new Card(4, 7));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.STRAIGHT_FLUSH, c1.getCombinationType());
		assertEquals(CombinationType.STRAIGHT_FLUSH, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) > 0);
		
	}
	
	public void testCompareCombinationsFlushRoyalNotEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(3, 13));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(3, 11));
		cards_list1.add(new Card(3, 10));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 14));
		cards_list2.add(new Card(4, 13));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(4, 11));
		cards_list2.add(new Card(4, 10));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.FLUSH_ROYAL, c1.getCombinationType());
		assertEquals(CombinationType.FLUSH_ROYAL, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) < 0);
		
	}

	public void testCompareCombinationsHighCardsEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(2, 14));
		cards_list1.add(new Card(3, 13));
		cards_list1.add(new Card(4, 12));
		cards_list1.add(new Card(1, 3));
		cards_list1.add(new Card(2, 2));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 13));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(1, 3));
		cards_list2.add(new Card(2, 2));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);
		
		assertEquals(CombinationType.HIGH_CARD, c1.getCombinationType());
		assertEquals(CombinationType.HIGH_CARD, c2.getCombinationType());
		assertEquals(0, c1.compareTo(c2));
		
	}	
	
	public void testCompareCombinationsPairsEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(2, 12));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(3, 3));
		cards_list1.add(new Card(3, 2));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 12));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(1, 3));
		cards_list2.add(new Card(2, 2));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);
		
		assertEquals(CombinationType.PAIR, c1.getCombinationType());
		assertEquals(CombinationType.PAIR, c2.getCombinationType());
		assertEquals(0, c1.compareTo(c2));
		
	}	

	public void testCompareCombinationsTwoPairsEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(2, 12));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(3, 3));
		cards_list1.add(new Card(3, 3));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 12));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(1, 3));
		cards_list2.add(new Card(2, 3));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);
		
		assertEquals(CombinationType.DOUBLE_PAIR, c1.getCombinationType());
		assertEquals(CombinationType.DOUBLE_PAIR, c2.getCombinationType());
		assertEquals(0, c1.compareTo(c2));
	}
	
	public void testCompareCombinationsTripletsEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(2, 12));
		cards_list1.add(new Card(1, 12));
		cards_list1.add(new Card(3, 3));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 12));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(1, 12));
		cards_list2.add(new Card(2, 3));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);
		
		assertEquals(CombinationType.TRIPLE, c1.getCombinationType());
		assertEquals(CombinationType.TRIPLE, c2.getCombinationType());
		assertEquals(0, c1.compareTo(c2));
		
	}	
	
	public void testCompareCombinationsStraightEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(4, 13));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(2, 11));
		cards_list1.add(new Card(3, 10));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(3, 14));
		cards_list2.add(new Card(4, 13));
		cards_list2.add(new Card(3, 12));
		cards_list2.add(new Card(2, 11));
		cards_list2.add(new Card(3, 10));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);
		
		assertEquals(CombinationType.STRAIGHT, c1.getCombinationType());
		assertEquals(CombinationType.STRAIGHT, c2.getCombinationType());
		assertEquals(0, c1.compareTo(c2));
		
	}	
	
	public void testCompareCombinationsFlushesEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 13));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(3, 11));
		cards_list1.add(new Card(3, 10));
		cards_list1.add(new Card(3, 8));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(3, 13));
		cards_list2.add(new Card(3, 12));
		cards_list2.add(new Card(3, 11));
		cards_list2.add(new Card(3, 10));
		cards_list2.add(new Card(3, 8));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.FLUSH, c1.getCombinationType());
		assertEquals(CombinationType.FLUSH, c2.getCombinationType());
		assertEquals(0, c1.compareTo(c2));
		
	}
	
	public void testCompareCombinationsFullHouseEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(2, 14));
		cards_list1.add(new Card(4, 14));
		cards_list1.add(new Card(2, 10));
		cards_list1.add(new Card(1, 10));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(3, 14));
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(3, 14));
		cards_list2.add(new Card(3, 10));
		cards_list2.add(new Card(3, 10));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.FULL_HOUSE, c1.getCombinationType());
		assertEquals(CombinationType.FULL_HOUSE, c2.getCombinationType());
		assertEquals(0, c1.compareTo(c2));
		
	}
	
	public void testCompareCombinationsQuadsEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(4, 12));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(2, 12));
		cards_list1.add(new Card(1, 12));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(3, 12));
		cards_list2.add(new Card(2, 12));
		cards_list2.add(new Card(1, 12));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);
		
		assertEquals(CombinationType.QUAD, c1.getCombinationType());
		assertEquals(CombinationType.QUAD, c2.getCombinationType());
		assertEquals(0, c1.compareTo(c2));
		
	}

	public void testCompareCombinationsStraightFlushEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(4, 13));
		cards_list1.add(new Card(4, 12));
		cards_list1.add(new Card(4, 11));
		cards_list1.add(new Card(4, 10));
		cards_list1.add(new Card(4, 9));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 13));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(4, 11));
		cards_list2.add(new Card(4, 10));
		cards_list2.add(new Card(4, 9));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.STRAIGHT_FLUSH, c1.getCombinationType());
		assertEquals(CombinationType.STRAIGHT_FLUSH, c2.getCombinationType());
		assertEquals(0, c1.compareTo(c2));
		
	}
	
	public void testCompareCombinationsFlushRoyalEquals() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(4, 14));
		cards_list1.add(new Card(4, 13));
		cards_list1.add(new Card(4, 12));
		cards_list1.add(new Card(4, 11));
		cards_list1.add(new Card(4, 10));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 14));
		cards_list2.add(new Card(4, 13));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(4, 11));
		cards_list2.add(new Card(4, 10));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.FLUSH_ROYAL, c1.getCombinationType());
		assertEquals(CombinationType.FLUSH_ROYAL, c2.getCombinationType());
		assertEquals(0, c1.compareTo(c2));
		
	}
	
	public void testCompareCombinationsPairMoreThanHighCard() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(4, 14));
		cards_list1.add(new Card(2, 13));
		cards_list1.add(new Card(4, 13));
		cards_list1.add(new Card(1, 11));
		cards_list1.add(new Card(4, 10));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 14));
		cards_list2.add(new Card(4, 13));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(2, 11));
		cards_list2.add(new Card(4, 2));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.PAIR, c1.getCombinationType());
		assertEquals(CombinationType.HIGH_CARD, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) > 0);
		
	}	
	
	public void testCompareCombinationsDoublePairMoreThanPair() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(4, 14));
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(4, 13));
		cards_list1.add(new Card(1, 11));
		cards_list1.add(new Card(4, 10));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 14));
		cards_list2.add(new Card(3, 14));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(2, 11));
		cards_list2.add(new Card(4, 11));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.PAIR, c1.getCombinationType());
		assertEquals(CombinationType.DOUBLE_PAIR, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) < 0);
		
	}

	public void testCompareCombinationsTripleMoreThanDoublePair() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(4, 14));
		cards_list1.add(new Card(3, 14));
		cards_list1.add(new Card(4, 14));
		cards_list1.add(new Card(1, 11));
		cards_list1.add(new Card(4, 10));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 14));
		cards_list2.add(new Card(3, 14));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(2, 11));
		cards_list2.add(new Card(4, 11));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.TRIPLE, c1.getCombinationType());
		assertEquals(CombinationType.DOUBLE_PAIR, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) > 0);
		
	}
	
	public void testCompareCombinationsStraightMoreThanTriple() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(4, 12));
		cards_list1.add(new Card(3, 11));
		cards_list1.add(new Card(4, 10));
		cards_list1.add(new Card(1, 9));
		cards_list1.add(new Card(4, 8));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 14));
		cards_list2.add(new Card(3, 14));
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(2, 11));
		cards_list2.add(new Card(4, 9));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.STRAIGHT, c1.getCombinationType());
		assertEquals(CombinationType.TRIPLE, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) > 0);
		
	}	
	
	public void testCompareCombinationsFlushMoreThanStright() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(4, 12));
		cards_list1.add(new Card(3, 11));
		cards_list1.add(new Card(4, 10));
		cards_list1.add(new Card(1, 9));
		cards_list1.add(new Card(4, 8));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 14));
		cards_list2.add(new Card(4, 9));
		cards_list2.add(new Card(4, 7));
		cards_list2.add(new Card(4, 3));
		cards_list2.add(new Card(4, 2));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.STRAIGHT, c1.getCombinationType());
		assertEquals(CombinationType.FLUSH, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) < 0);
		
	}
	
	public void testCompareCombinationsFullHouseMoreThanFlush() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(4, 12));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(2, 12));
		cards_list1.add(new Card(4, 8));
		cards_list1.add(new Card(1, 8));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 14));
		cards_list2.add(new Card(4, 9));
		cards_list2.add(new Card(4, 7));
		cards_list2.add(new Card(4, 3));
		cards_list2.add(new Card(4, 2));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.FULL_HOUSE, c1.getCombinationType());
		assertEquals(CombinationType.FLUSH, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) > 0);
		
	}
	
	public void testCompareCombinationsQuadMoreThanFullHouse() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(4, 12));
		cards_list1.add(new Card(3, 12));
		cards_list1.add(new Card(2, 12));
		cards_list1.add(new Card(4, 8));
		cards_list1.add(new Card(1, 8));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 14));
		cards_list2.add(new Card(3, 14));
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(1, 14));
		cards_list2.add(new Card(4, 2));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.FULL_HOUSE, c1.getCombinationType());
		assertEquals(CombinationType.QUAD, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) < 0);
		
	}
	
	public void testCompareCombinationsStraightFlushMoreThanQuad() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(2, 12));
		cards_list1.add(new Card(2, 11));
		cards_list1.add(new Card(2, 10));
		cards_list1.add(new Card(2, 9));
		cards_list1.add(new Card(2, 8));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 14));
		cards_list2.add(new Card(3, 14));
		cards_list2.add(new Card(2, 14));
		cards_list2.add(new Card(1, 14));
		cards_list2.add(new Card(4, 2));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.STRAIGHT_FLUSH, c1.getCombinationType());
		assertEquals(CombinationType.QUAD, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) > 0);
		
	}
	
	public void testCompareCombinationsFlushRoyalMoreThanStraightFlush() {

		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(2, 12));
		cards_list1.add(new Card(2, 11));
		cards_list1.add(new Card(2, 10));
		cards_list1.add(new Card(2, 9));
		cards_list1.add(new Card(2, 8));

		List<Card> cards_list2 = new ArrayList<Card>();
		cards_list2.add(new Card(4, 14));
		cards_list2.add(new Card(4, 13));
		cards_list2.add(new Card(4, 12));
		cards_list2.add(new Card(4, 11));
		cards_list2.add(new Card(4, 10));

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertEquals(CombinationType.STRAIGHT_FLUSH, c1.getCombinationType());
		assertEquals(CombinationType.FLUSH_ROYAL, c2.getCombinationType());
		assertTrue(c1.compareTo(c2) < 0);
		
	}

	public void testCompareCombinationsAdditionalTest1() {
	
		List<Card> cards_list1 = new ArrayList<Card>();
		cards_list1.add(new Card(1,14));
		cards_list1.add(new Card(2,13));
		cards_list1.add(new Card(4,12));
		cards_list1.add(new Card(2,12));
		cards_list1.add(new Card(1,12));
        cards_list1.add(new Card(4,4));
        cards_list1.add(new Card(3,3));

	    List<Card> cards_list2 = new ArrayList<Card>();
	    cards_list2.add(new Card(2,2));
	    cards_list2.add(new Card(4,5));
	    cards_list2.add(new Card(2,11));
	    cards_list2.add(new Card(3,7));
	    cards_list2.add(new Card(2,8));
        cards_list2.add(new Card(2,7));
        cards_list2.add(new Card(1,7));

	    Combination c1 = new Combination(cards_list1);
	    Combination c2 = new Combination(cards_list2);
	
	    c1.compareTo(c2);
	}
    
	public void testCompareCombinationsAdditionalTest2() {

		List<Card> cards_list1 = new ArrayList<Card>() {{ 
			add(new Card(2, 2));
			add(new Card(4, 11));
			add(new Card(1, 4));
			add(new Card(3, 3));
			add(new Card(1, 10));
			add(new Card(2, 4));
			add(new Card(4, 8));
		}};
		
		List<Card> cards_list2 = new ArrayList<Card>() {{ 
			add(new Card(3, 9));
			add(new Card(1, 9));
			add(new Card(1, 13));
			add(new Card(4, 2));
			add(new Card(3, 12));
			add(new Card(1, 11));
			add(new Card(4, 10));
		}};

		Combination c1 = new Combination(cards_list1);
		Combination c2 = new Combination(cards_list2);

		assertTrue(c1.compareTo(c2) < 0);
		
	}
	
	private void assertCardsArrays(List<Card> cards1, List<Card> cards2) {
		assertEquals(cards1.size(), cards2.size());
		for (int i = 0; i < cards1.size(); i++) {
			assertEquals(cards1.get(i), cards2.get(i));
		}
	}

}

