package com.dinesh.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dinesh.flight.entity.DepartureFlight;

@Repository
public interface DepartureFlightDaoRepository extends JpaRepository<DepartureFlight, Long> {

}
