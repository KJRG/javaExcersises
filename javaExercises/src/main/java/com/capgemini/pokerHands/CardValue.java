package com.capgemini.pokerHands;

public enum CardValue {
	
	/*
	 * each card value has a char (used to find the correct card when
	 * reading from file) and a value (used to evaluate the hand of player)
	 */

	TWO('2', 2),
	THREE('3', 3),
	FOUR('4', 4),
	FIVE('5', 5),
	SIX('6', 6),
	SEVEN('7', 7),
	EIGHT('8', 8),
	NINE('9', 9),
	TEN('T', 10),
	JACK('J', 11),
	QUEEN('Q', 12),
	KING('K', 13),
	ACE('A', 14);

	char charIdentifier;
	int value;

	private CardValue(final char c, final int val) {
		this.charIdentifier = c;
		this.value = val;
	}

	public char getCharacter() {
		return charIdentifier;
	}

	public int getValue() {
		return value;
	}

	public static CardValue fromChar(char c) {
		for (CardValue cv : CardValue.values()) {
			if (cv.charIdentifier == Character.toUpperCase(c)) {
				return cv;
			}
		}

		throw new IllegalArgumentException("No constant with char " + c + " found");
	}
}
