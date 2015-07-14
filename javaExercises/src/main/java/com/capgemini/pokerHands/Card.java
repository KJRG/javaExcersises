package com.capgemini.pokerHands;

public class Card {
	private CardValue value;
	private char suit;

	public Card(CardValue cv, char s) {
		this.value = cv;
		this.suit = s;
	}

	public int getValue() {
		return this.value.getValue();
	}

	public char getSuit() {
		return this.suit;
	}
}
