package com.capgemini.pokerHands;

public class Card {
	private CardValue value;
	private char suit;

	public Card(CardValue cv, char s) {
		this.value = cv;
		this.suit = s;
	}

	public CardValue getValue() {
		return this.value;
	}

	public char getSuit() {
		return this.suit;
	}
}
