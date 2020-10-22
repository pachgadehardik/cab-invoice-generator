package com.capg.cabinvoicegenerator.Exceptions;

@SuppressWarnings("unused")
public class CabInvoiceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum ExceptionType{
		NULLRECORD, OTHERTYPE
	}
	
	private ExceptionType exceptionType;
	private String msg;
	public CabInvoiceException(ExceptionType exceptionType,String msg) {
		super(msg);
		this.exceptionType = exceptionType;
	}
	
}
