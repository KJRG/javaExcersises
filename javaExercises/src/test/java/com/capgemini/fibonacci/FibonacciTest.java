package com.capgemini.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void shouldReturn0ForMinus1() {
		assertEquals(0, Fibonacci.fib(-1));
	}

	@Test
	public void shouldReturn0For0() {
		assertEquals(0, Fibonacci.fib(0));
	}

	@Test
	public void shouldReturn1For1() {
		assertEquals(1, Fibonacci.fib(1));
	}

	@Test
	public void shouldReturn1For2() {
		assertEquals(1, Fibonacci.fib(2));
	}

	@Test
	public void shouldReturn2For3() {
		assertEquals(2, Fibonacci.fib(3));
	}

	@Test
	public void shouldReturn3For4() {
		assertEquals(3, Fibonacci.fib(4));
	}

	@Test
	public void shouldReturn5For5() {
		assertEquals(5, Fibonacci.fib(5));
	}

}
