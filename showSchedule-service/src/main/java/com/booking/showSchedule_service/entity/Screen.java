package com.booking.showSchedule_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;


@Entity
@Table(name = "SCREEN", schema = "SYS")
@Data
@Getter
public class Screen {
    @Id
    @Column(name = "SCREEN_ID")
    private String screenId;
    
    @ManyToOne // Links Screen to Theatre
    @JoinColumn(name = "THEATRE_ID")
    //@JsonBackReference
    private Theatre theatre;
    
    @Column(name = "SCREEN_NAME", nullable = false)
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

	
}
