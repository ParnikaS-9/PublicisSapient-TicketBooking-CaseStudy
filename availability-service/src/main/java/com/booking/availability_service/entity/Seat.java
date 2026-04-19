package com.booking.availability_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name = "SEAT")
public class Seat {
    @Id @Column(name = "SEAT_ID") private String seatId;
    @Column(name = "FARE_ID") private String fareId;
    @Column(name = "SCREEN_ID") private String screenId;
    @Column(name = "SCREEN_ROW") private Integer screenRow;
    @Column(name = "SEAT_NUM") private Integer seatNum;
    @Column(name = "STATUS") private String status;
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getFareId() {
		return fareId;
	}
	public void setFareId(String fareId) {
		this.fareId = fareId;
	}
	public String getScreenId() {
		return screenId;
	}
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}
	public Integer getScreenRow() {
		return screenRow;
	}
	public void setScreenRow(Integer screenRow) {
		this.screenRow = screenRow;
	}
	public Integer getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Seat(String seatId, String fareId, String screenId, Integer screenRow, Integer seatNum, String status) {
		super();
		this.seatId = seatId;
		this.fareId = fareId;
		this.screenId = screenId;
		this.screenRow = screenRow;
		this.seatNum = seatNum;
		this.status = status;
	}
	public Seat() {
		super();
	}
    
}