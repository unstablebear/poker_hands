package com.zl.poker;

class Card implements Comparable {

    private int suit;
    private int value;

    private Card() {
        
    }

    public Card(int suit, int value) {
        if(suit < 1 || suit > 4)
	    throw new IllegalArgumentException("Suit must be between 1 and 4");
        if(value < 2 || value > 14)
	    throw new IllegalArgumentException("Value must be between 2 and 14");
        this.suit = suit;
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public int compareTo(Object anotherCard) throws ClassCastException {
        if (!(anotherCard instanceof Card)) {
            throw new ClassCastException("A Card object expected.");
        }
        if(this.getValue() > ((Card)anotherCard).getValue()) {
            return -1;
        } else if(this.getValue() < ((Card)anotherCard).getValue()) {
            return 1;
        } else return ((Card)anotherCard).getSuit() - this.getSuit();
    }

    @Override 
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getSuit();
        result = 31 * result + this.getValue();
        return result;
    }
    
    @Override 
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Card)) {
            return false;
        }
        Card c = (Card)o;
        if(c.getSuit() == this.getSuit() && c.getValue() == this.getValue()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Card : suit = %s, value = %s", getSuit(), getValue());
    }

}
