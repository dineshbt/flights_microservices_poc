package com.dinesh.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.flight.entity.DepartureFlight;

public interface FlightDepartureDaoRepository extends JpaRepository<DepartureFlight, Long>{

}
