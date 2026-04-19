package com.booking.theatre_service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SHOW_SCHEDULE", schema = "SYS")
@Data
public class ShowSchedule {
	@Id
	//@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "SHOW_SCHEDULE_ID")
	private String showScheduleId;

	@Column(name = "MOVIE_ID")
	private String movieId;

	@Column(name = "MOVIE_TIME")
	private LocalDateTime movieTime;

	@Column(name = "MOVIE_DATE")
	private LocalDate movieDate;

	// Relationship: Many schedules belong to one Screen
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCREEN_ID", referencedColumnName = "SCREEN_ID")
	@JsonBackReference
	private Screen screen;

	public String getShowScheduleId() {
		return showScheduleId;
	}

	public void setShowScheduleId(String showScheduleId) {
		this.showScheduleId = showScheduleId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public LocalDateTime getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(LocalDateTime movieTime) {
		this.movieTime = movieTime;
	}

	public LocalDate getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(LocalDate movieDate) {
		this.movieDate = movieDate;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public ShowSchedule(String showScheduleId, String movieId, LocalDateTime movieTime, LocalDate movieDate,
			Screen screen) {
		super();
		this.showScheduleId = showScheduleId;
		this.movieId = movieId;
		this.movieTime = movieTime;
		this.movieDate = movieDate;
		this.screen = screen;
	}

	public ShowSchedule() {
		super();
	}
	
	
}
