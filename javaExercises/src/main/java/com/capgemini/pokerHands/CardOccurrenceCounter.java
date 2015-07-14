package com.capgemini.pokerHands;

public class CardOccurrenceCounter implements Comparable<CardOccurrenceCounter> {

	private int cardValue, numOfOccurrences;

	public int getCardValue() {
		return cardValue;
	}

	public int getNumOfOccurrences() {
		return numOfOccurrences;
	}

	public CardOccurrenceCounter(int key, int value) {
		super();
		this.cardValue = key;
		this.numOfOccurrences = value;
	}

	public int compareTo(CardOccurrenceCounter o) {
		return (this.numOfOccurrences == o.numOfOccurrences) ? (this.cardValue - o.cardValue) : (this.numOfOccurrences - o.numOfOccurrences);
	}

}
