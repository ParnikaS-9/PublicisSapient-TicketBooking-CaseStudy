package com.booking.availability_service.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class SeatShowId implements Serializable {
    private String seatId;
    private String showScheduleId;
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getShowScheduleId() {
		return showScheduleId;
	}
	public void setShowScheduleId(String showScheduleId) {
		this.showScheduleId = showScheduleId;
	}
	public SeatShowId(String seatId, String showScheduleId) {
		this.seatId = seatId;
		this.showScheduleId = showScheduleId;
	}
	public SeatShowId() {
	}
	
}
