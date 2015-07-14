package com.capgemini.taxi;

import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaxiThread extends Taxi implements Runnable {

	private static int RUNS = 5;
	private Thread t;
	private String ThreadName;
	private Random r;
	
	public TaxiThread(int x, int y, boolean isFree, String taxiId) {
		super(x, y, isFree, taxiId);
		ThreadName = "Thread " + taxiId;
		r = new Random();
	}

	public void run() {
		for(int i = 0; i < RUNS; i++) {
			
			// Choose random position
			this.ChangePosition(r.nextInt(200), r.nextInt(200), true);
			
			// TODO Fix random availability
			// Was taken - is not, was not taken - is
//			this.isFree = !this.isFree;
			
			// Sleep for a while
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void start() {
		if(t == null) {
			t = new Thread(this, ThreadName);
			t.start();
		}
	}

	public static void main(String args[]) {
		List<TaxiThread> taxiThreads = new ArrayList<TaxiThread>();
		FindNearestTaxi fnt = new FindNearestTaxi(3, 6548, 2157);
		for(int i = 0; i < 5; i++) {
			taxiThreads.add(new TaxiThread(1777, 2458, true, "Taxi " + i));
			fnt.addTaxi(taxiThreads.get(i));
		}
		for(TaxiThread tt: taxiThreads) {
			tt.start();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ThreadName == null) ? 0 : ThreadName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxiThread other = (TaxiThread) obj;
		if (ThreadName == null) {
			if (other.ThreadName != null)
				return false;
		} else if (!ThreadName.equals(other.ThreadName))
			return false;
		return true;
	}
	
	
}
