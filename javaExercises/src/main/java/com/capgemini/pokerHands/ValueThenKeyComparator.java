package com.capgemini.pokerHands;

public class ValueThenKeyComparator implements Comparable<ValueThenKeyComparator> {

	private int key,
				value;

	public int getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}

	public ValueThenKeyComparator(int key, int value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public int compareTo(ValueThenKeyComparator o) {
		return (this.value==o.value)?(this.key-o.key):(this.value-o.value);
	}
	
}
