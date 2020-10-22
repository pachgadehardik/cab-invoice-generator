package com.capg.cabinvoicegenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.capg.cabinvoicegenerator.Enums.RideCategories;
import com.capg.cabinvoicegenerator.Exceptions.CabInvoiceException;
import com.capg.cabinvoicegenerator.POJO.InvoiceSummary;
import com.capg.cabinvoicegenerator.POJO.Ride;
import com.capg.cabinvoicegenerator.Services.InvoiceService;

public class InvoiceServiceTest {

	@Test
	public void givenDistanceTime_ReturnFare() {
		InvoiceService invoiceGenerator = new InvoiceService(RideCategories.NORMAL_RIDES);
		double distance = 2.0;
		int time = 5;
		assertEquals(25, invoiceGenerator.calculateFare(distance, time), 0.0);
	}

	@Test
	public void givenLessDistanceOrTime_ShouldReturnMinFare() {
		InvoiceService invoiceGenerator = new InvoiceService(RideCategories.NORMAL_RIDES);
		double distance = 0.1;
		int time = 1;
		assertEquals(5, invoiceGenerator.calculateFare(distance, time), 0.0);
	}

	@Test
	public void givenMultipleRideShouldReturnReturnInvoiceSummary() {
		InvoiceService invoiceGenerator = new InvoiceService(RideCategories.NORMAL_RIDES);
		ArrayList<Ride> rides = new ArrayList<Ride>();
		Collections.addAll(rides, new Ride(2.0, 5), new Ride(0.1, 1));
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
		assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

	@Test
	public void givenUserIdReturnsListofRides() throws CabInvoiceException {
		InvoiceService invoiceService = new InvoiceService(RideCategories.NORMAL_RIDES);
		Map<Integer, ArrayList<Ride>> mapRides = new HashMap<>();
		ArrayList<Ride> rideList1 = new ArrayList<Ride>();
		ArrayList<Ride> rideList2 = new ArrayList<Ride>();

		Collections.addAll(rideList1, new Ride(2.0, 5), new Ride(0.1, 1));
		mapRides.put(1, rideList1);
		Collections.addAll(rideList2, new Ride(3.0, 5), new Ride(0.1, 1));
		mapRides.put(2, rideList2);
		invoiceService.addRidesToRepo(mapRides);
		invoiceService.getInvoiceSummary(1);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60);
		assertEquals(expectedInvoiceSummary, invoiceService.getInvoiceSummary(1));
	}
	
	@Test
	public void givenPremiumRidesShouldGiveTotalFare() {
		InvoiceService invoiceService = new InvoiceService(RideCategories.PREMIUM_RIDES);
		double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        assertEquals(40, fare, 0.0);
	}
	
	

}
