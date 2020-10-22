package com.capg.cabinvoicegenerator;

public class InvoiceGenerator {

	private static final int MINIMUM_COST_PER_KM = 10;
	private static final int MINIMUM_COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double totalFare = MINIMUM_COST_PER_KM * distance + time * MINIMUM_COST_PER_TIME;
		 if(totalFare < MINIMUM_FARE)
			 return MINIMUM_FARE;
		return totalFare;
	}

	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += calculateFare(ride.distance, ride.time);
		}
		return totalFare;
	}

}
