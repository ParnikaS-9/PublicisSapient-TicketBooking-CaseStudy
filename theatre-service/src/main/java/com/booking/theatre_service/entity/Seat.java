package com.booking.theatre_service.entity;

import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Persistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;

@Entity
public class Seat implements Persistable<String>{
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seat_id_seq")
	//@SequenceGenerator(name = "seat_id_seq", sequenceName = "seat_id_seq", allocationSize = 1)
	@Column(name = "SEAT_ID")
    private String seatId;
    @ManyToOne
    @JoinColumn(name = "FARE_ID")
    private Fare fare;
    @ManyToOne
    @JoinColumn(name = "SCREEN_ID")
    private Screen screen;
    private Integer screenRow;
    private Integer seatNum;
    private String status; // A and B
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public Fare getFare() {
		return fare;
	}
	public void setFare(Fare fare) {
		this.fare = fare;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
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
	public Seat(String seatId, Fare fare, Screen screen, Integer screenRow, Integer seatNum, String status) {
		super();
		this.seatId = seatId;
		this.fare = fare;
		this.screen = screen;
		this.screenRow = screenRow;
		this.seatNum = seatNum;
		this.status = status;
	}
	public Seat() {
		super();
	}
	@Transient
    private boolean isNew = true; // Logic flag

    @Override
    public String getId() {
        return seatId;
    }

    @Override
    public boolean isNew() {
        return isNew; 
    }

    @PostLoad
    @PostPersist
    void markNotNew() {
        this.isNew = false;
    }
    
}
