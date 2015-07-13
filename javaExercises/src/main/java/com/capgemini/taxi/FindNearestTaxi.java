package com.capgemini.taxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class FindNearestTaxi implements Observer {
	private static final int MAX_DISTANCE = 1000;	// max distance between a taxi and the user
	
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
		
		if(t.isFree() && clientPosition.Distance(t.position) <= MAX_DISTANCE) {
			nearTaxis.add(t);
		}
		else {
			nearTaxis.remove(t);
		}
	}

	public void update(Observable o, Object arg) {
		Taxi t = (Taxi) arg;
		
		if(t.isFree() && clientPosition.Distance(t.position) <= MAX_DISTANCE) {
			nearTaxis.add(t);
		}
		else {
			nearTaxis.remove(t);
		}
	}
	
	public List<Taxi> getNearestTaxis() {
		List<Taxi> nearest = new ArrayList<Taxi>(nearTaxis);
		TaxiDistanceComparator tdk = new TaxiDistanceComparator(clientPosition.getX(), clientPosition.getY());
		
		Collections.sort(nearest, tdk);
		
		if(nearest.size() < maxNumOfTaxisToReturn) {
			return nearest.subList(0, nearest.size());
		}
		return nearest.subList(0, maxNumOfTaxisToReturn);
	}
}
