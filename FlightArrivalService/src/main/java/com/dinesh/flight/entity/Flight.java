package com.dinesh.flight.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "flight_number")
	private Long flightNumber;

	@Column(name = "flight_name")
	private String flightName;

	
	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch =
	FetchType.EAGER) private Set<ArrivalFlight> arrivalFlights;
	
	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch =
	FetchType.EAGER) private Set<DepartureFlight> departureFlights;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public Long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Set<ArrivalFlight> getArrivalFlights() { return arrivalFlights; }
	public void setArrivalFlights(Set<ArrivalFlight> arrivalFlights) {
	this.arrivalFlights = arrivalFlights; } public Set<DepartureFlight>
	getDepartureFlights() { return departureFlights; } public void
	setDepartureFlights(Set<DepartureFlight> departureFlights) {
	this.departureFlights = departureFlights; }
	
	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", flightName=" + flightName + "]";
	}

}
