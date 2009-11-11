package com.zl.poker;

public enum CombinationType { 

    HIGH_CARD(0),
    PAIR(1),
    DOUBLE_PAIR(2),
    TRIPLE(3),
    STRAIGHT(4),
    FLUSH(5),
    FULL_HOUSE(6),
    QUAD(7),
    STRAIGHT_FLUSH(8),
    FLUSH_ROYAL (9); 

    public final int val;

    CombinationType(int val) {
	this.val = val;
    }

}