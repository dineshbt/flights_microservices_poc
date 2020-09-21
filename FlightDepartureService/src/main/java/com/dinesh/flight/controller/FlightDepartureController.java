package com.dinesh.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.flight.entity.model.DepartureFlightVO;
import com.dinesh.flight.service.FlightDepartureService;

@RestController
public class FlightDepartureController {
	
	@Autowired
	FlightDepartureService flightDepartureService;
	
	@RequestMapping("/flights/departure")
	List<DepartureFlightVO> getDepartureFlights() {
		
		return flightDepartureService.getDepartureFlights();
	}
}
