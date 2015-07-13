package com.capgemini.pokerHands;

public enum Rank {
	// each rank has a value used to evaluate the hand of player
	// example: one pair with highest card 3 gives 13 + value of 3 (which - in this project - is 1) = 14
	
	HIGH_CARD(0),
	ONE_PAIR(1),
	TWO_PAIRS(2),
	THREE(3),
	STRAIGHT(4),
	FLUSH(5),
	FULL_HOUSE(6),
	FOUR(7),
	STRAIGHT_FLUSH(8),
	ROYAL_FLUSH(9);
	
	private int rv;
	
	private Rank(final int rv) {
		this.rv = rv;
	}
	
	public int getValue() {
		return rv;
	}
}
