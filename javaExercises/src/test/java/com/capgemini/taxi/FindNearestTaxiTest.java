package com.capgemini.taxi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class FindNearestTaxiTest {

	@Test
	public void shouldReturnEmptyListForNoTaxis() {
		FindNearestTaxi fnt = new FindNearestTaxi(5, 1000, 1000);
		List<Taxi> expected = Collections.emptyList();

		assertEquals(expected, fnt.getNearestTaxis());
	}

	@Test
	public void shouldReturnEmptyListForNoNearTaxis() {
		FindNearestTaxi fnt = new FindNearestTaxi(5, 1000, 1000);
		List<Taxi> expected = Collections.emptyList();
		List<Taxi> taxis = Arrays.asList(
				new Taxi(5000, 5000, true, "Taxi 1"),
				new Taxi(6000, 6000, true, "Taxi 2"),
				new Taxi(7000, 7000, true, "Taxi 3"));

		for (Taxi t : taxis) {
			fnt.addTaxi(t);
		}

		assertEquals(expected, fnt.getNearestTaxis());
	}

	@Test
	public void shouldReturnEmptyListForNoFreeTaxis() {
		FindNearestTaxi fnt = new FindNearestTaxi(5, 1000, 1000);
		List<Taxi> expected = Collections.emptyList();
		List<Taxi> taxis = Arrays.asList(
				new Taxi(1100, 1100, false, "Taxi 1"),
				new Taxi(1200, 1200, false, "Taxi 2"),
				new Taxi(1300, 1300, false, "Taxi 3"));

		for (Taxi t : taxis) {
			fnt.addTaxi(t);
		}

		assertEquals(expected, fnt.getNearestTaxis());
	}

	@Test
	public void shouldReturnOnlyTaxi1() {
		FindNearestTaxi fnt = new FindNearestTaxi(5, 1000, 1000);
		Taxi[] taxis = {
				new Taxi(1100, 1100, true, "Taxi 1"),
				new Taxi(1200, 1200, false, "Taxi 2"),
				new Taxi(7000, 7000, false, "Taxi 3") };
		List<Taxi> expected = new ArrayList<Taxi>();

		expected.add(taxis[0]);
		for (Taxi t : taxis) {
			fnt.addTaxi(t);
		}

		assertEquals(expected, fnt.getNearestTaxis());
	}

	@Test
	public void shouldReturnTaxis1_2_3() {
		FindNearestTaxi fnt = new FindNearestTaxi(4, 1000, 1000);
		Taxi[] taxis = {
				new Taxi(1100, 1100, true, "Taxi 1"),
				new Taxi(1200, 1200, true, "Taxi 2"),
				new Taxi(1300, 1300, true, "Taxi 3") };
		List<Taxi> expected = new ArrayList<Taxi>();

		for (Taxi t : taxis) {
			expected.add(t);
			fnt.addTaxi(t);
		}

		assertEquals(expected, fnt.getNearestTaxis());
	}

	@Test
	public void shouldReturnTaxis1_2_3_4() {
		FindNearestTaxi fnt = new FindNearestTaxi(4, 1000, 1000);
		Taxi[] taxis = {
				new Taxi(1100, 1100, true, "Taxi 1"),
				new Taxi(1200, 1200, true, "Taxi 2"),
				new Taxi(1300, 1300, true, "Taxi 3"),
				new Taxi(1400, 1400, true, "Taxi 4") };
		List<Taxi> expected = new ArrayList<Taxi>();

		for (Taxi t : taxis) {
			expected.add(t);
			fnt.addTaxi(t);
		}

		assertEquals(expected, fnt.getNearestTaxis());
	}

	@Test
	public void shouldReturnTaxis1_2_3_AndIgnore4() {
		FindNearestTaxi fnt = new FindNearestTaxi(3, 1000, 1000);
		Taxi[] taxis = {
				new Taxi(1100, 1100, true, "Taxi 1"),
				new Taxi(1200, 1200, true, "Taxi 2"),
				new Taxi(1300, 1300, true, "Taxi 3"),
				new Taxi(1400, 1400, true, "Taxi 4") };
		List<Taxi> expected = new ArrayList<Taxi>();

		for (int i = 0; i < taxis.length - 1; i++) {
			fnt.addTaxi(taxis[i]);
			expected.add(taxis[i]);
		}
		fnt.addTaxi(taxis[taxis.length - 1]);

		assertEquals(expected, fnt.getNearestTaxis());
	}

	@Test
	public void shouldReturnTheSameTaxis1_2_3_4() {
		FindNearestTaxi fnt = new FindNearestTaxi(4, 1000, 1000);
		Taxi[] taxis = {
				new Taxi(1100, 1100, true, "Taxi 1"),
				new Taxi(1150, 1150, true, "Taxi 2"),
				new Taxi(1200, 1200, true, "Taxi 3"),
				new Taxi(1250, 1250, true, "Taxi 4") };
		List<Taxi> expected = new ArrayList<Taxi>();

		for (Taxi t : taxis) {
			expected.add(t);
			fnt.addTaxi(t);
		}
		taxis[3].ChangePosition(1210, 1210, true);

		assertEquals(expected, fnt.getNearestTaxis());
	}

	@Test
	public void shouldReturnTaxis1_2_AndIgnoreTaxis3_4() {
		FindNearestTaxi fnt = new FindNearestTaxi(4, 1000, 1000);
		Taxi[] taxis = {
				new Taxi(1100, 1100, true, "Taxi 1"),
				new Taxi(1150, 1150, true, "Taxi 2"),
				new Taxi(1200, 1200, true, "Taxi 3"),
				new Taxi(1250, 1250, true, "Taxi 4") };
		List<Taxi> expected = new ArrayList<Taxi>();

		for (int i = 0; i < taxis.length; i++) {
			if (i < 2) {
				expected.add(taxis[i]);
			}
			fnt.addTaxi(taxis[i]);
		}
		taxis[2].ChangePosition(5500, 7800, true);
		taxis[3].ChangePosition(1210, 1210, false);

		assertEquals(expected, fnt.getNearestTaxis());
	}
}
