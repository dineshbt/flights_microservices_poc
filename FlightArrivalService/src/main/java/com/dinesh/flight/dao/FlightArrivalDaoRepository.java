package com.dinesh.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dinesh.flight.entity.ArrivalFlight;

@Repository
public interface FlightArrivalDaoRepository extends JpaRepository<ArrivalFlight, Long>{
	//JpaRepository does all the things.
}
