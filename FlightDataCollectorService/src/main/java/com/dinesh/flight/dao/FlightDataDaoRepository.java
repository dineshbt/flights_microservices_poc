package com.dinesh.flight.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dinesh.flight.entity.Flight;



@Repository
public interface FlightDataDaoRepository extends JpaRepository<Flight, Long>{
	Optional<Flight> findByFlightNumber(Long flightNumber);
}
