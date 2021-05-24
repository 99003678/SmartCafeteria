package com.ltts.shadow.smartcafeteria.Models;

public class ServiceOccupancyAverage {

	
	private float count;
	
	private int times;

	public ServiceOccupancyAverage(float count, int times) {
		super();
		this.count = count;
		this.times = times;
	}

	public ServiceOccupancyAverage() {
		super();
	}

	public float getCount() {
		return count;
	}

	public void setCount(float count) {
		this.count = count;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "CurrentOccupancyAverage [count=" + count + ", times=" + times + "]";
	}



	

}
