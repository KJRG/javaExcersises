package com.capgemini.pokerHands;

public class CardOccurrenceCounter implements Comparable<CardOccurrenceCounter> {

	private int numOfOccurrences;
	private CardValue cardValue;

	public CardValue getCardValue() {
		return cardValue;
	}

	public int getNumOfOccurrences() {
		return numOfOccurrences;
	}

	public CardOccurrenceCounter(CardValue key, int value) {
		super();
		this.cardValue = key;
		this.numOfOccurrences = value;
	}

	public int compareTo(CardOccurrenceCounter o) {
		return (this.numOfOccurrences == o.numOfOccurrences) ? (this.cardValue.getValue() - o.cardValue.getValue()) : (this.numOfOccurrences - o.numOfOccurrences);
	}

}
