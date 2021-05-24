package com.ltts.shadow.smartcafeteria.Models;

public class HistoricalOccupancyService {


	private float count;
	
	private int date;

	public HistoricalOccupancyService(float count, int date) {
		super();
		this.count = count;
		this.date = date;
	}

	public HistoricalOccupancyService() {
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
		return "HistoricalOccupancyService [count=" + count + ", date=" + date + "]";
	}
	
	
	
	
	
}
