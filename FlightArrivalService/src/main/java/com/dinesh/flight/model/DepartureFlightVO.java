package com.dinesh.flight.model;

public class DepartureFlightVO extends FlightVO{
	private String actualDepartureTime;
	private String estimatedDepartureTime;
	private String origin;
	private String destination;
	
	public String getActualDepartureTime() {
		return actualDepartureTime;
	}
	public void setActualDepartureTime(String actualDepartureTime) {
		this.actualDepartureTime = actualDepartureTime;
	}
	public String getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}
	public void setEstimatedDepartureTime(String estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
