package com.dinesh.flight.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.flight.model.ArrivalFlightVO;

@RestController
public class FlightController {
	
	@RequestMapping("/flights/arrival")
	public List<ArrivalFlightVO> getArrivalFlights() {
		
		List<ArrivalFlightVO> arrivalFlights = new ArrayList<>();
		
		ArrivalFlightVO arrivalFlight = new ArrivalFlightVO();
		arrivalFlight.setFlightNumber(101L);
		arrivalFlight.setFlightName("Indigo");
		arrivalFlight.setOrigin("Delhi");
		arrivalFlight.setDestination("Bangalore");
		arrivalFlight.setActualArrivalTime("10:20 AM");
		arrivalFlight.setEstimatedArrivalTime("10:50 AM");
		
		arrivalFlights.add(arrivalFlight);
		return arrivalFlights;
	}

}
