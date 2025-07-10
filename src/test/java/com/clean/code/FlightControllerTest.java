package com.clean.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.clean.code.exceptions.DuplicateFlightException;
import com.clean.code.exceptions.FlightNotFoundException;
import com.clean.code.tdd.Flight;
import com.clean.code.tdd.FlightController;

@SpringBootTest 
public class FlightControllerTest {

	private FlightController flightController;
	
	@BeforeEach
	public void setUp() {
		flightController = new FlightController();
	}
	
	@Test
	public void givenEmptyFligthController_whenFligthAdded_thenGetByReferenceReturnsFlight() {
		LocalDate date = LocalDate.of(2025, 07, 9);
		LocalTime time = LocalTime.of(2, 30);
		Flight flight = new Flight("1", createDateTimeForFlight(date, time), 
				"Madrid", "Barcelona");
		
		flightController.addFlight(flight);
		
		assertEquals(flight, flightController.findFlightByReference("1"));
	}
	
	@Test
	public void givenEmptyFlightController_whenGetByReference_thenThrowFlightNotFoundException() {
		assertThrows(FlightNotFoundException.class, () -> 
			flightController.findFlightByReference("1"));
	}
	
	@Test
	public void givenFligthControllerWithFligth_wWhenSameFlightAdded_thenThrowDuplicateFlightException() {
		LocalDate date = LocalDate.of(2025, 07, 9);
		LocalTime time = LocalTime.of(2, 30);
		Flight flight = new Flight("1", createDateTimeForFlight(date, time), 
				"Madrid", "Barcelona");
		
		flightController.addFlight(flight);
		
		assertThrows(DuplicateFlightException.class, () -> 
			flightController.addFlight(flight));
	}
	
	public LocalDateTime createDateTimeForFlight(LocalDate date, LocalTime time ) {
		return LocalDateTime.of(date, time);
	}
}