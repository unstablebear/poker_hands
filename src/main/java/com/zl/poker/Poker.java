package com.zl.poker;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Poker {
    
    public void sortCards(List<Card> cards) {
        Collections.sort(cards);
    }

    public Combination getCombination(List<Card> cards) {
        return new Combination(cards);
    }

}

