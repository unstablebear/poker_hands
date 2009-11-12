package com.zl.poker;

import java.util.Collections;
import java.util.List;

class Poker {
    
    public void sortCards(List<Card> cards) {
        Collections.sort(cards);
    }

    public Combination createCombination(List<Card> cards) {
        return new Combination(cards);
    }
    
    public int compareCombinations(Combination c1, Combination c2) {
    	return c1.compareTo(c2);
    }

}

