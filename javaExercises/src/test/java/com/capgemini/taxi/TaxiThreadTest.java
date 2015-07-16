package com.capgemini.taxi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TaxiThreadTest {

	@Test(timeout = 10000)
	public void test() {
		List<TaxiThread> taxiThreads = new ArrayList<TaxiThread>();
		FindNearestTaxi fnt = new FindNearestTaxi(3, 100, 100);
		for(int i = 0; i < 5; i++) {
			taxiThreads.add(new TaxiThread(1777, 2458, true, "Taxi " + i));
		}
		for(TaxiThread tt : taxiThreads){
			fnt.addTaxi(tt);
		}
		for(TaxiThread tt: taxiThreads) {
			tt.start();
		}
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		List<Taxi> nearest = fnt.getNearestTaxis();
	}
}
