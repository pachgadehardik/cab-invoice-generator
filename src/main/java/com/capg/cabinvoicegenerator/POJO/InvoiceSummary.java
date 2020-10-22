package com.capg.cabinvoicegenerator.POJO;

public class InvoiceSummary {

	private double average;
	private int noOfRides;
	private double fare;

	public InvoiceSummary(int noOfRides, double fare) {
		this.noOfRides = noOfRides;
		this.fare = fare;
		this.average = this.fare/this.noOfRides;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(average) != Double.doubleToLongBits(other.average))
			return false;
		if (Double.doubleToLongBits(fare) != Double.doubleToLongBits(other.fare))
			return false;
		if (noOfRides != other.noOfRides)
			return false;
		return true;
	}
	
	
	

}
