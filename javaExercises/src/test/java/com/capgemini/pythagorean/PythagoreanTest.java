package com.capgemini.pythagorean;

import static org.junit.Assert.*;

import org.junit.Test;

public class PythagoreanTest {

	@Test
	public void shouldReturn31875000() {
		assertEquals(31875000, Pythagorean.GetTripletProduct());
	}

}
