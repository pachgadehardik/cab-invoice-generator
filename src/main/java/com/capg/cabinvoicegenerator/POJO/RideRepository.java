package com.capg.cabinvoicegenerator.POJO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {

	private Map<Integer, ArrayList<Ride>> rideBook;
	

	public RideRepository() {
		this.rideBook = new HashMap<>();
	}

	public Map<Integer, ArrayList<Ride>> getRideBook() {
		return rideBook;
	}

	public void setRideBook(Map<Integer, ArrayList<Ride>> rideBook) {
		this.rideBook = rideBook;
	}

}
