package com.capgemini.pokerHands;

public enum Rank {
	
	/*
	 * each rank has a value used to evaluate the hand of player
	 */
	
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
	
	private int rankValue;
	
	private Rank(final int rv) {
		this.rankValue = rv;
	}
	
	public int getValue() {
		return rankValue;
	}
}
