package com.capgemini.taxi;

import java.util.Observable;

public class Taxi extends Observable {
	Point position;
	private boolean isFree;
	private String taxiId;

	public Taxi(int x, int y, boolean isFree, String taxiId) {
		position = new Point(x, y);
		this.isFree = isFree;
		this.taxiId = taxiId;
	}

	public int getPosX() {
		return position.getX();
	}

	public int getPosY() {
		return position.getY();
	}

	public boolean isFree() {
		return isFree;
	}

	public String getTaxiId() {
		return taxiId;
	}

	public void ChangePosition(int x, int y) {
		position.setX(x);
		position.setY(y);

		setChanged();
		notifyObservers(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taxiId == null) ? 0 : taxiId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Taxi other = (Taxi) obj;
		if (taxiId == null) {
			if (other.taxiId != null)
				return false;
		} else if (!taxiId.equals(other.taxiId))
			return false;
		return true;
	}

}
