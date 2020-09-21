package com.dinesh.flight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling    
//EnableScheduling enables the scheduling part
public class FlightDataCollectorServiceApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(FlightDataCollectorServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FlightDataCollectorServiceApplication.class, args);
		
		logger.info("******** FlightDataCollector Service *******");
	}

}
