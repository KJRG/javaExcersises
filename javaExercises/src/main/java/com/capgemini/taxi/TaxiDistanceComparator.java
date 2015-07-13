package com.capgemini.taxi;

import java.util.Comparator;

public class TaxiDistanceComparator implements Comparator<Taxi> {
	private Point clientPosition;

	public TaxiDistanceComparator(int x, int y) {
		clientPosition = new Point(x, y);
	}

	public int compare(Taxi one, Taxi two) {
		double dist1 = clientPosition.Distance(one.position);
		double dist2 = clientPosition.Distance(two.position);

		return Double.compare(dist1, dist2);
	}
}
