package com.booking.theatre_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Fare {
    @Id
    private String fareId;
    @Column(name = "CLASS")
    private String seatClass; 
    private Double price;
	public String getFareId() {
		return fareId;
	}
	public void setFareId(String fareId) {
		this.fareId = fareId;
	}
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Fare(String fareId, String seatClass, Double price) {
		super();
		this.fareId = fareId;
		this.seatClass = seatClass;
		this.price = price;
	}
	public Fare() {
		super();
	}
}
