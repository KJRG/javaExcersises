package com.capgemini.coins;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CoinsTest {

	@Test
	public void shouldReturn4For1_1_0_1_0_0() {
		List<Integer> coinsList = Arrays.asList(1, 1, 0, 1, 0, 0); // +2 (4)
		assertEquals(4, Coins.solution(coinsList));
	}

	@Test
	public void shouldReturn4For1_1_0_0_0_1() {
		List<Integer> coinsList = Arrays.asList(1, 1, 0, 0, 0, 1); // +1 (4)
		assertEquals(4, Coins.solution(coinsList));
	}

	@Test
	public void shouldReturn4For1_1_1_1_1_1() {
		List<Integer> coinsList = Arrays.asList(1, 1, 1, 1, 1, 1); // -1 (4)
		assertEquals(4, Coins.solution(coinsList));
	}

	@Test
	public void shouldReturn0For1() {
		List<Integer> coinsList = Arrays.asList(1); // size = 1 (0)
		assertEquals(0, Coins.solution(coinsList));
	}
}
