package com.dinesh.flight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.flight.dao.FlightDepartureDaoRepository;
import com.dinesh.flight.entity.DepartureFlight;
import com.dinesh.flight.entity.model.DepartureFlightVO;

@Service
public class FlightDepartureService {

	@Autowired
	FlightDepartureDaoRepository flightDepartureDaoRepository;
	
	public List<DepartureFlightVO> getDepartureFlights() {
		List<DepartureFlight> departureFlightsDB = flightDepartureDaoRepository.findAll();
		List<DepartureFlightVO> departureFlightsVO = new ArrayList<>();
		
		for (DepartureFlight departureFlight : departureFlightsDB) {
			DepartureFlightVO departureVO = new DepartureFlightVO();
			departureVO.setFlightNumber(departureFlight.getFlight().getFlightNumber());
			departureVO.setFlightName(departureFlight.getFlight().getFlightName());
			departureVO.setOrigin(departureFlight.getOrigin());
			departureVO.setDestination(departureFlight.getDestination());
			departureVO.setActualDepartureTime(departureFlight.getActualDepartureTime());
			departureVO.setEstimatedDepartureTime(departureFlight.getEstimatedDepartureTime());
			departureFlightsVO.add(departureVO);
		}
		return departureFlightsVO;
	}
}
