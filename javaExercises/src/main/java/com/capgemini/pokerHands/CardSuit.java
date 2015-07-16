package com.capgemini.pokerHands;

public enum CardSuit {
	SPADES('S'), CLUBS('C'), DIAMONDS('D'), HEARTS('H');
	
	char suit;
	
	private CardSuit(final char suit) {
		this.suit = suit;
	}
	
	public char getCharacter() {
		return this.suit;
	}
	
	public static CardSuit fromChar(final char s) {
		for(CardSuit cs : CardSuit.values()) {
			if(cs.suit == s) {
				return cs;
			}
		}
		
		throw new IllegalArgumentException("No constant with char " + s + " found");
	}
}
