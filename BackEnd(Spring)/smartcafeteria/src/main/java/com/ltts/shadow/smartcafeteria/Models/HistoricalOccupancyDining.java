package com.ltts.shadow.smartcafeteria.Models;

public class HistoricalOccupancyDining {


	private float count;
	
	private int date;

	public HistoricalOccupancyDining(float count, int date) {
		super();
		this.count = count;
		this.date = date;
	}

	public HistoricalOccupancyDining() {
		super();
	}

	public float getCount() {
		return count;
	}

	public void setCount(float count) {
		this.count = count;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "HistoricalOccupancyDining [count=" + count + ", date=" + date + "]";
	}
	
	
	
	
	
}
