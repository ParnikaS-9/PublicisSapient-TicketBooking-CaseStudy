package com.booking.booking_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity 
@Table(name = "BOOKINGS")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "booking_id_seq", allocationSize = 1)
    @Column(name = "BOOKING_ID")
    private Long bookingId;

    @Column(name = "MOVIE_ID")
    private String movieId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "SHOW_SCHD_ID")
    private String showSchdId;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShowSchdId() {
		return showSchdId;
	}

	public void setShowSchdId(String showSchdId) {
		this.showSchdId = showSchdId;
	}

	public Booking(Long bookingId, String movieId, String userId, String showSchdId) {
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.userId = userId;
		this.showSchdId = showSchdId;
	}

	public Booking() {
	}
    
}
