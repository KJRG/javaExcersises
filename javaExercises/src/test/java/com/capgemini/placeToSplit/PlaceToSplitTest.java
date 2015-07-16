package com.capgemini.placeToSplit;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlaceToSplitTest {

	@Test
	public void shouldReturnFalseFor1() {
		int[] array = {1};
		assertFalse(PlaceToSplit.canBalance(array));
	}

	@Test
	public void shouldReturnTrueFor1_1() {
		int[] array = {1, 1};
		assertTrue(PlaceToSplit.canBalance(array));
	}

	@Test
	public void shouldReturnTrueFor1_2_3() {
		int[] array = {1, 2, 3};
		assertTrue(PlaceToSplit.canBalance(array));
	}

	@Test
	public void shouldReturnFalseFor1_1_7() {
		int[] array = {1, 1, 7};
		assertFalse(PlaceToSplit.canBalance(array));
	}

	@Test
	public void shouldReturnTrueFor1_1_2_5_5_4() {
		int[] array = {1, 1, 2, 5, 5, 4};
		assertTrue(PlaceToSplit.canBalance(array));
	}

	@Test
	public void shouldReturnTrueFor1_1_1_2_1() {
		int[] array = {1, 1, 1, 2, 1};
		assertTrue(PlaceToSplit.canBalance(array));
	}

	@Test
	public void shouldReturnFalseFor2_1_1_2_1() {
		int[] array = {2, 1, 1, 2, 1};
		assertFalse(PlaceToSplit.canBalance(array));
	}

	@Test
	public void shouldReturnTrueFor10_10() {
		int[] array = {10, 10};
		assertTrue(PlaceToSplit.canBalance(array));
	}

}
