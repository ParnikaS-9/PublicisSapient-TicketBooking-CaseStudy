package com.booking.showSchedule_service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "SHOW_SCHEDULE", schema = "SYS")
@Data
@Getter
@AllArgsConstructor
public class ShowSchedule {
    @Id
    @Column(name = "SHOW_SCHEDULE_ID")
    private String showScheduleId;
    
    @Column(name = "MOVIE_ID")
    private String movieId;
    
    @Column(name = "MOVIE_DATE")
    private LocalDate movieDate;
    private LocalDateTime movieTime;

    @ManyToOne // Links Schedule to Screen
    @JoinColumn(name = "SCREEN_ID")
    //@JsonBackReference
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

	public LocalDate getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(LocalDate movieDate) {
		this.movieDate = movieDate;
	}

	public LocalDateTime getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(LocalDateTime movieTime) {
		this.movieTime = movieTime;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	
}
