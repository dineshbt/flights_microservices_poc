package com.dinesh.flight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.flight.dao.FlightArrivalDaoRepository;
import com.dinesh.flight.entity.ArrivalFlight;
import com.dinesh.flight.model.ArrivalFlightVO;

@Service
public class FlightArrivalService {
	
	@Autowired
	FlightArrivalDaoRepository flightArrivalDaoRepository;
	
	public List<ArrivalFlightVO> getArrivalFlights() {
		List<ArrivalFlight> arrivalFlightsDB = flightArrivalDaoRepository.findAll();
		List<ArrivalFlightVO> arrivalFlightsVO = new ArrayList<>();
		
		for (ArrivalFlight arrivalFlight : arrivalFlightsDB) {
			ArrivalFlightVO ArrivalVO = new ArrivalFlightVO();
			ArrivalVO.setFlightNumber(arrivalFlight.getFlight().getFlightNumber());
			ArrivalVO.setFlightName(arrivalFlight.getFlight().getFlightName());
			ArrivalVO.setOrigin(arrivalFlight.getOrigin());
			ArrivalVO.setDestination(arrivalFlight.getDestination());
			ArrivalVO.setActualArrivalTime(arrivalFlight.getActualArrivalTime());
			ArrivalVO.setEstimatedArrivalTime(arrivalFlight.getEstimatedArrivalTime());
			arrivalFlightsVO.add(ArrivalVO);
		}
		return arrivalFlightsVO;
	}
}
