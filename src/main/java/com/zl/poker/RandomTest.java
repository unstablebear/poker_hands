package com.zl.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		
		Random rnd = new Random(); 
		
		long iterations = 2000000000; 
		long combinationsCount = 0;
		
		while(combinationsCount++ < iterations) {
			
			int cardsCount = 5 + rnd.nextInt(5);
			List<Card> cards1 = new ArrayList<Card>(cardsCount);
			List<Card> cards2 = new ArrayList<Card>(cardsCount);
			for (int i = 0; i < cardsCount; i++) {
				cards1.add(new Card(1 + rnd.nextInt(3), 2 + rnd.nextInt(12)));
				cards2.add(new Card(1 + rnd.nextInt(3), 2 + rnd.nextInt(12)));
			}
			
			try {
				
				Combination c1 = new Combination(cards1);
				Combination c2 = new Combination(cards2);
				
				c1.compareTo(c2);
				
			} catch (Exception e) {
				System.out.println("ERROR ! \n Card1 \n");
				for (Card card : cards1) {
					System.out.println(String.format("add(new Card(%s, %s));", card.getSuit(), card.getValue()));
				}
				System.out.println("ERROR ! \n Card2 \n");
				for (Card card : cards2) {
					System.out.println(String.format("add(new Card(%s, %s));", card.getSuit(), card.getValue()));
				}
				e.printStackTrace();
			}
			
			if(combinationsCount % 1000 == 0) {
				System.out.println(String.format("iterations completed: %s", combinationsCount));
			}
			
		}
		
	}
	
}
