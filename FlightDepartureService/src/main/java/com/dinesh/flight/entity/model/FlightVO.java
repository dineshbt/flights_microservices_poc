package com.dinesh.flight.entity.model;

import java.io.Serializable;

public class FlightVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long flightNumber;
	private String flightName;
	
	
	public Long getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(Long flightId) {
		this.flightNumber = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightNumber + ", flightName=" + flightName + "]";
	}
	
	
}
