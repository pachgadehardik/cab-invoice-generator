package com.capg.cabinvoicegenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {

	@Test
	public void givenDistanceTime_ReturnFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		assertEquals(25, invoiceGenerator.calculateFare(distance, time),0.0);
	}
	
	@Test
	public void givenLessDistanceOrTime_ShouldReturnMinFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		assertEquals(5, invoiceGenerator.calculateFare(distance, time),0.0);
	}
	
	@Test
	public void givenMultipleRideShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = {new Ride(2.0, 5),new Ride(0.1, 1)};
		
		assertEquals(30, invoiceGenerator.calculateFare(rides));
	}
}
