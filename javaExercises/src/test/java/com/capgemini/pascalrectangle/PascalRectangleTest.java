package com.capgemini.pascalrectangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class PascalRectangleTest {

	/**
	 * column -1, row -1
	 */
	@Test
	public void shouldReturn0ForMinus1_Minus1() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(0, pr.pascal(-1, -1));
	}

	/**
	 * column -1, row 0
	 */
	@Test
	public void shouldReturn0ForMinus1_0() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(0, pr.pascal(-1, 0));
	}

	/**
	 * column -1, row 1
	 */
	@Test
	public void shouldReturn0ForMinus1_1() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(0, pr.pascal(-1, 1));
	}

	/**
	 * column 0, row -1
	 */
	@Test
	public void shouldReturn0For0_Minus1() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(0, pr.pascal(0, -1));
	}

	/**
	 * column 0, row 0
	 */
	@Test
	public void shouldReturn1For0_0() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(1, pr.pascal(0, 0));
	}

	/**
	 * column 0, row 1
	 */
	@Test
	public void shouldReturn1For0_1() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(1, pr.pascal(0, 1));
	}

	/**
	 * column 1, row -1
	 */
	@Test
	public void shouldReturn0For1_Minus1() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(0, pr.pascal(1, -1));
	}

	/**
	 * column 1, row 0
	 */
	@Test
	public void shouldReturn0For1_0() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(0, pr.pascal(1, 0));
	}

	/**
	 * column 1, row 1
	 */
	@Test
	public void shouldReturn1For1_1() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(1, pr.pascal(1, 1));
	}

	/**
	 * column 1, row 2
	 */
	@Test
	public void shouldReturn2For1_2() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(2, pr.pascal(1, 2));
	}

	/**
	 * column 1, row 3
	 */
	@Test
	public void shouldReturn3For1_3() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(3, pr.pascal(1, 3));
	}

	/**
	 * column 2, row 3
	 */
	@Test
	public void shouldReturn3For2_3() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(3, pr.pascal(2, 3));
	}

	/**
	 * column 2, row 4
	 */
	@Test
	public void shouldReturn6For2_4() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(6, pr.pascal(2, 4));
	}

	/**
	 * column 4, row 8
	 */
	@Test
	public void shouldReturn70For4_8() {
		PascalRectangle pr = new PascalRectangle();

		assertEquals(70, pr.pascal(4, 8));
	}

}
