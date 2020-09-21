package com.dinesh.flight.model;

public class ArrivalFlightVO extends FlightVO{
	private String actualArrivalTime;
	private String estimatedArrivalTime;
	private String origin;
	private String destination;
	
	public String getActualArrivalTime() {
		return actualArrivalTime;
	}
	public void setActualArrivalTime(String actualArrivalTime) {
		actualArrivalTime = actualArrivalTime;
	}
	public String getEstimatedArrivalTime() {
		return estimatedArrivalTime;
	}
	public void setEstimatedArrivalTime(String estimatedArrivalTime) {
		estimatedArrivalTime = estimatedArrivalTime;
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
