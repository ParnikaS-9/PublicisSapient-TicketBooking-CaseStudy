package com.booking.availability_service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name = "SHOW_SCHEDULE")
public class ShowSchedule {
    @Id @Column(name = "SHOW_SCHEDULE_ID") private String showScheduleId;
    @Column(name = "MOVIE_ID") private String movieId;
    @Column(name = "SCREEN_ID") private String screenId;
    @Column(name = "MOVIE_TIME") private LocalDateTime movieTime;
    @Column(name = "MOVIE_DATE") private LocalDate movieDate;
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
	public String getScreenId() {
		return screenId;
	}
	public void setScreenId(String screenId) {
		this.screenId = screenId;
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
	public ShowSchedule(String showScheduleId, String movieId, String screenId, LocalDateTime movieTime,
			LocalDate movieDate) {
		super();
		this.showScheduleId = showScheduleId;
		this.movieId = movieId;
		this.screenId = screenId;
		this.movieTime = movieTime;
		this.movieDate = movieDate;
	}
	public ShowSchedule() {
	}
    
}
