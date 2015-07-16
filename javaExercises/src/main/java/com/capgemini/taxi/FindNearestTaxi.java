package com.capgemini.taxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class FindNearestTaxi implements Observer {

	private static final int MAX_DISTANCE_TO_CLIENT = 1000;

	private int maxNumOfTaxisToReturn;
	private Point clientPosition;
	private Set<Taxi> nearTaxis;

	public FindNearestTaxi(int maxNumOfTaxisToReturn, int x, int y) {
		this.maxNumOfTaxisToReturn = maxNumOfTaxisToReturn;
		clientPosition = new Point(x, y);
		nearTaxis = new HashSet<Taxi>();
	}

	public void addTaxi(Taxi t) {
		t.addObserver(this);
		updateTaxiData(t);
	}

	public void update(Observable o, Object arg) {
		Taxi t = (Taxi) arg;
		updateTaxiData(t);
	}

	private void updateTaxiData(Taxi t) {
		if (t.isFree() && clientPosition
				.Distance(t.position) <= MAX_DISTANCE_TO_CLIENT) {
			nearTaxis.add(t);
			return;
		}

		nearTaxis.remove(t);
	}

	public List<Taxi> getNearestTaxis() {
		List<Taxi> nearest = new ArrayList<Taxi>(nearTaxis);
		TaxiDistanceComparator tdk = new TaxiDistanceComparator(
				clientPosition.getX(), clientPosition.getY());

		Collections.sort(nearest, tdk);

		if (nearest.size() < maxNumOfTaxisToReturn) {
			return nearest;
		}
		return nearest.subList(0, maxNumOfTaxisToReturn);
	}
}
