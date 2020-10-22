package com.capg.cabinvoicegenerator.Enums;

public enum RideCategories {

	NORMAL_RIDES {

		@Override
		public double calculateFare(double distance, int time) {
			Double totalFare = distance * 10 + time * 1;
			return Math.max(totalFare, 5);
		}
	},

	PREMIUM_RIDES {
		@Override
		public double calculateFare(double distance, int time) {
			Double totalFare = distance * 15 + time * 2;
			return Math.max(totalFare, 20);
		}
	};

	public abstract double calculateFare(double distance, int time);

}
