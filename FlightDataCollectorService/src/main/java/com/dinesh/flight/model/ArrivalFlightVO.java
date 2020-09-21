package com.dinesh.flight.model;

public class ArrivalFlightVO extends FlightVO{
	private String ActualArrivalTime;
	private String EstimatedArrivalTime;
	private String origin;
	private String destination;
	
	public String getActualArrivalTime() {
		return ActualArrivalTime;
	}
	public void setActualArrivalTime(String actualArrivalTime) {
		ActualArrivalTime = actualArrivalTime;
	}
	public String getEstimatedArrivalTime() {
		return EstimatedArrivalTime;
	}
	public void setEstimatedArrivalTime(String estimatedArrivalTime) {
		EstimatedArrivalTime = estimatedArrivalTime;
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
