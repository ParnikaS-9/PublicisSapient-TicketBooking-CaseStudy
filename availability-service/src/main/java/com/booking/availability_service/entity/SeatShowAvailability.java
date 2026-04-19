package com.booking.availability_service.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity @Table(name = "SEAT_SHOW_AVAILABILITY_MAPPER")
public class SeatShowAvailability {
    @EmbeddedId private SeatShowId id;
    private String availability; // 'A' for Available, 'B' for Booked
    
    @ManyToOne @MapsId("seatId") @JoinColumn(name = "SEAT_ID")
    private Seat seat;

	public SeatShowId getId() {
		return id;
	}

	public void setId(SeatShowId id) {
		this.id = id;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public SeatShowAvailability(SeatShowId id, String availability, Seat seat) {
		this.id = id;
		this.availability = availability;
		this.seat = seat;
	}

	public SeatShowAvailability() {
	}
    
    
}
