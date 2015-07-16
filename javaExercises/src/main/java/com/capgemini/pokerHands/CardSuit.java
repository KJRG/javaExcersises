package com.capgemini.pokerHands;

public enum CardSuit {

	/*
	 * each card suit has a char (used to find the correct card when reading
	 * from file)
	 */

	SPADES('S'),
	CLUBS('C'),
	DIAMONDS('D'),
	HEARTS('H');

	char suit;

	private CardSuit(final char suit) {
		this.suit = suit;
	}

	public char getCharacter() {
		return this.suit;
	}

	public static CardSuit fromChar(final char s) {
		for (CardSuit cs : CardSuit.values()) {
			if (cs.suit == Character.toUpperCase(s)) {
				return cs;
			}
		}

		throw new IllegalArgumentException(
				"No constant with char " + s + " found");
	}
}
