package com.booking.theatre_service.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Screen {
    @Id
    @Column(name = "SCREEN_ID")
    private String screenId;
    @ManyToOne
    @JoinColumn(name = "THEATRE_ID")
    @JsonBackReference
    private Theatre theatre;
    private String screenName;
	public String getScreenId() {
		return screenId;
	}
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public Screen(String screenId, Theatre theatre, String screenName) {
		super();
		this.screenId = screenId;
		this.theatre = theatre;
		this.screenName = screenName;
	}
	public Screen() {
		super();
	}
    
}
