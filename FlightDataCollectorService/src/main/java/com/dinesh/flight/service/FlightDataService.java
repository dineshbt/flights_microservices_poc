package com.dinesh.flight.service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.flight.dao.ArrivalFlightDaoRepository;
import com.dinesh.flight.dao.DepartureFlightDaoRepository;
import com.dinesh.flight.dao.FlightDataDaoRepository;
import com.dinesh.flight.entity.ArrivalFlight;
import com.dinesh.flight.entity.DepartureFlight;
import com.dinesh.flight.entity.Flight;
import com.dinesh.flight.model.ArrivalFlightVO;
import com.dinesh.flight.model.DepartureFlightVO;
import com.dinesh.flight.model.FlightVO;

@Service
public class FlightDataService {
	
	@Autowired
	FlightDataDaoRepository flightDaoRepository;
	
	@Autowired
	ArrivalFlightDaoRepository arrivalFlightDaoRepository;
	
	@Autowired
	DepartureFlightDaoRepository departureFlightDaoRepository;
	
	public boolean upsert(FlightVO flightVO) throws Exception {
		
		Optional<Flight> flightDB = flightDaoRepository.findByFlightNumber(flightVO.getFlightNumber());
	
		if(flightDB.isPresent()) {
			// Flight exists update the record with timing details.
			if(flightVO instanceof DepartureFlightVO) {
				Set<DepartureFlight> departureFlightSet = flightDB.get().getDepartureFlights();
				DepartureFlight[] departureFlightArray = departureFlightSet.toArray(new DepartureFlight[departureFlightSet.size()]);
				DepartureFlight departureFlightDB = departureFlightArray[0];
				departureFlightDB.setUpdatedAt(new Date(System.currentTimeMillis()));
				departureFlightDaoRepository.save(departureFlightDB);
				
			} else {
				// ArrivalFlightVO
				Set<ArrivalFlight> arrivalFlightSet = flightDB.get().getArrivalFlights();
				ArrivalFlight[] arrivalFlightArray = arrivalFlightSet.toArray(new ArrivalFlight[arrivalFlightSet.size()]);
				ArrivalFlight arrivalFlightDB = arrivalFlightArray[0];
				arrivalFlightDB.setUpdatedAt(new Date(System.currentTimeMillis()));
				arrivalFlightDaoRepository.save(arrivalFlightDB);
			}
		} else {
			//insert a new record
			if(flightVO instanceof DepartureFlightVO) {
				//insert departureFlightVO instance.
				DepartureFlightVO departureFlightVO = (DepartureFlightVO)flightVO;
				DepartureFlight departureFlight = new DepartureFlight();
				Flight flight = new Flight();
				flight.setFlightNumber(flightVO.getFlightNumber());
				flight.setFlightName(flightVO.getFlightName());
				
				departureFlight.setOrigin(departureFlightVO.getOrigin());
				departureFlight.setDestination(departureFlightVO.getDestination());
				departureFlight.setActualDepartureTime(departureFlightVO.getActualDepartureTime());
				departureFlight.setEstimatedDepartureTime(departureFlightVO.getEstimatedDepartureTime());
				departureFlight.setFlight(flight);
				departureFlight.setCreatedAt(new Date(System.currentTimeMillis()));
				departureFlight.setUpdatedAt(new Date(System.currentTimeMillis()));
				departureFlightDaoRepository.save(departureFlight);
				
			} else {
				//insert ArrivalFlightVO instance.
				ArrivalFlightVO arrivalFlightVO = (ArrivalFlightVO)flightVO;
				Flight flight = new Flight();
				ArrivalFlight arrivalFlight = new ArrivalFlight();
				
				flight.setFlightNumber(flightVO.getFlightNumber());
				flight.setFlightName(arrivalFlightVO.getFlightName());
				arrivalFlight.setOrigin(arrivalFlightVO.getOrigin());
				arrivalFlight.setDestination(arrivalFlightVO.getDestination());
				arrivalFlight.setActualArrivalTime(arrivalFlightVO.getActualArrivalTime());
				arrivalFlight.setEstimatedArrivalTime(arrivalFlightVO.getEstimatedArrivalTime());
				arrivalFlight.setFlight(flight);
				arrivalFlight.setCreatedAt(new Date(System.currentTimeMillis()));
				arrivalFlight.setUpdatedAt(new Date(System.currentTimeMillis()));
				arrivalFlightDaoRepository.save(arrivalFlight);
			}
		}
		
		return true;
	}

}
