package com.dinesh.flight.collector;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dinesh.flight.model.ArrivalFlightVO;
import com.dinesh.flight.model.DepartureFlightVO;
import com.dinesh.flight.model.FlightVO;
import com.dinesh.flight.service.FlightDataService;

@Component
public class FlightDataCollector {
	
	@Autowired
	FlightDataService flightDataService;

	@Scheduled(cron = "*/5 * * * * *") // every 5 seconds this gets invoked
	public void runTask() {
		System.out.println("********** Task invoked ************");
		List<FlightVO> flights = getFlights();
		int randomNumber = generateRandomIntRange(0, 5);
		System.out.println("randomNumber generated ="+randomNumber);
		FlightVO flight = flights.get(randomNumber);
		System.out.println("flight picked ="+flight);
		//flight.set to update the time later
		try {
			flightDataService.upsert(flight);
		}catch(Exception e) {
			System.out.println("exception occured while saving");
			e.printStackTrace();
		}
	}
	
	private static String getCurrentTimeInString() {
		long currentMilliseconds = System.currentTimeMillis();
		Date date = new Date(currentMilliseconds);
		SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
		
		String formattedTime = sdf2.format(date);
		return formattedTime;
	}
	
	public static int generateRandomIntRange(int min, int max) {
	    Random r = new Random();
	    return r.nextInt((max - min) + 1) + min;
	}

	private static List<FlightVO>getFlights() {
		List<FlightVO> flights = new ArrayList<>();
		
		ArrivalFlightVO arrivalFlight = new ArrivalFlightVO();
		arrivalFlight.setFlightNumber(101L);
		arrivalFlight.setFlightName("Indigo");
		arrivalFlight.setOrigin("Delhi");
		arrivalFlight.setDestination("Bangalore");
		arrivalFlight.setActualArrivalTime("10:20 AM");
		arrivalFlight.setEstimatedArrivalTime("10:50 AM");
		flights.add(arrivalFlight);
		
		ArrivalFlightVO arrivalFlight1 = new ArrivalFlightVO();
		arrivalFlight1.setFlightNumber(102L);
		arrivalFlight1.setFlightName("KingFisher");
		arrivalFlight1.setOrigin("Mumbai");
		arrivalFlight1.setDestination("Bangalore");
		arrivalFlight1.setActualArrivalTime("11:20 AM");
		arrivalFlight1.setEstimatedArrivalTime("11:55 AM");
		flights.add(arrivalFlight1);
		
		ArrivalFlightVO arrivalFlight2 = new ArrivalFlightVO();
		arrivalFlight2.setFlightNumber(103L);
		arrivalFlight2.setFlightName("KingFisher");
		arrivalFlight2.setOrigin("Kolkotta");
		arrivalFlight2.setDestination("Bangalore");
		arrivalFlight2.setActualArrivalTime("12:20 AM");
		arrivalFlight2.setEstimatedArrivalTime("12:35 AM");
		flights.add(arrivalFlight2);
		
		//departure flights
		DepartureFlightVO departureFlight = new DepartureFlightVO();
		departureFlight.setFlightNumber(204L);
		departureFlight.setFlightName("Indian Airlines");
		departureFlight.setOrigin("Bangalore");
		departureFlight.setDestination("Chennai");
		departureFlight.setEstimatedDepartureTime("8:15 AM");
		departureFlight.setActualDepartureTime("8:30 AM");
		flights.add(departureFlight);
		
		DepartureFlightVO departureFlight1 = new DepartureFlightVO();
		departureFlight1.setFlightNumber(305L);
		departureFlight1.setFlightName("Indigo");
		departureFlight1.setOrigin("Bangalore");
		departureFlight1.setDestination("Hyderabad");
		departureFlight1.setEstimatedDepartureTime("7:15 AM");
		departureFlight1.setActualDepartureTime("8:30 AM");
		flights.add(departureFlight1);
		
		DepartureFlightVO departureFlight2 = new DepartureFlightVO();
		departureFlight2.setFlightNumber(406L);
		departureFlight2.setFlightName("Air Asia");
		departureFlight2.setOrigin("Bangalore");
		departureFlight2.setDestination("Delhi");
		departureFlight2.setEstimatedDepartureTime("11:15 AM");
		departureFlight2.setActualDepartureTime("2:30 PM");
		flights.add(departureFlight2);
		return flights;
	}

}
