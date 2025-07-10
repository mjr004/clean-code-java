package com.clean.code.tdd;

import java.util.HashMap;
import java.util.Map;

import com.clean.code.exceptions.DuplicateFlightException;
import com.clean.code.exceptions.FlightNotFoundException;

public class FlightController {

	private Map<String,Flight> flights;
	
	public FlightController() {
		this.flights = new HashMap<>(); 
	}	
	
	public void addFlight(Flight flight) {
		Flight exisFlight = flights.get(flight.getReference());
		if(exisFlight != null) {
			throw new DuplicateFlightException();
		}
		
		flights.put(flight.getReference(),flight);
	}

	public Flight findFlightByReference(String reference) {
		if(flights.containsKey(reference)) {
			return flights.get(reference);
		}
		
		throw new FlightNotFoundException();
	}
}