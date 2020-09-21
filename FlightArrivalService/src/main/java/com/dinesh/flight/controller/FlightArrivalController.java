package com.dinesh.flight.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.flight.model.ArrivalFlightVO;
import com.dinesh.flight.service.FlightArrivalService;

@RestController
public class FlightArrivalController {
	private static final Logger logger = LoggerFactory.getLogger(FlightArrivalController.class);
	
	@Autowired
	FlightArrivalService flightArrivalService;
	
	@RequestMapping("/flights/arrival")
	public List<ArrivalFlightVO> getArrivalFlights() {
		logger.info("controller getArrivalFlights() method invoked.");
		return flightArrivalService.getArrivalFlights();
	}
	
}
