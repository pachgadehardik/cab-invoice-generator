package com.capg.cabinvoicegenerator.Services;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.capg.cabinvoicegenerator.Enums.RideCategories;
import com.capg.cabinvoicegenerator.Exceptions.CabInvoiceException;
import com.capg.cabinvoicegenerator.Exceptions.CabInvoiceException.ExceptionType;
import com.capg.cabinvoicegenerator.POJO.InvoiceSummary;
import com.capg.cabinvoicegenerator.POJO.Ride;
import com.capg.cabinvoicegenerator.POJO.RideRepository;

public class InvoiceService {
	
	
	
	
	private static final int MINIMUM_COST_PER_KM = 10;
	private static final int MINIMUM_COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;
	private static final Logger logger = LogManager.getLogger(InvoiceService.class);

	RideRepository rideRepository;
	private RideCategories rideCategories;
	public InvoiceService() {
		this.rideRepository = new RideRepository();
		
	}
	public InvoiceService(RideCategories rideCategories) {
	        this.rideRepository = new RideRepository();
	        this.rideCategories = rideCategories;
	}

	Map<Integer, ArrayList<Ride>> rideBook;

	public double calculateFare(double distance, int time) {
		return rideCategories.calculateFare(distance, time);
	}
	

	public InvoiceSummary calculateFare(ArrayList<Ride> arrayList) {
	    DOMConfigurator.configure("log4j.xml");

		double totalFare = 0;
		for (Ride ride : arrayList) {
			totalFare += rideCategories.calculateFare(ride.distance, ride.time);
		}
		logger.info("Calculating Invoice");
		return new InvoiceSummary(arrayList.size(), totalFare);
	}

	public void addRidesToRepo(Map<Integer, ArrayList<Ride>> mapRides) throws CabInvoiceException {
		if(mapRides == null)
			throw new CabInvoiceException(ExceptionType.NULLRECORD, "No Such Record Found!");
		DOMConfigurator.configure("log4j.xml");
		logger.info("Added Rides to Map");
		rideRepository.setRideBook(mapRides);
	}

	public InvoiceSummary getInvoiceSummary(int id) throws CabInvoiceException {
		DOMConfigurator.configure("log4j.xml");
		rideBook = rideRepository.getRideBook();
		if(rideBook == null)
			throw new CabInvoiceException(ExceptionType.NULLRECORD, "No Such Record Found!");
		logger.info("Calculated and Generated Invoice Summary");
		return calculateFare(rideBook.get(id));

	}

}
