package com.capgemini.pokerHands;

public class Card {
	private CardValue value;
	private CardSuit suit;

	public Card(CardValue cv, CardSuit s) {
		this.value = cv;
		this.suit = s;
	}

	public CardValue getValue() {
		return this.value;
	}

	public CardSuit getSuit() {
		return this.suit;
	}
}
