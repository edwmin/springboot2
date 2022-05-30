package com.stock.Exeception;

import java.util.Date;

public class ExceptionResponse {
	private Date timestano;
	private String message;
	private String details;
	
	public Date getTimestano() {
		return timestano;
	}
	
	public ExceptionResponse(Date timestano, String message, String details) {
		super();
		this.timestano = timestano;
		this.message = message;
		this.details = details;
	}
	
	public void setTimestano(Date timestano) {
		this.timestano = timestano;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
