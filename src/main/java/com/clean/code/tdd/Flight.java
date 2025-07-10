package com.clean.code.tdd;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
	private String reference;
	private LocalDateTime departureDate;
	private String origin;
	private String destination;
	
	public Flight(String reference, LocalDateTime departureDate, String origin, String destination) {
		super();
		this.reference = reference;
		this.departureDate = departureDate;
		this.origin = origin;
		this.destination = destination;
	}

	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public LocalDateTime getDepartureDate() {
		return departureDate;
	}
	
	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departureDate, destination, origin, reference);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(departureDate, other.departureDate) && Objects.equals(destination, other.destination)
				&& Objects.equals(origin, other.origin) && Objects.equals(reference, other.reference);
	}
}
