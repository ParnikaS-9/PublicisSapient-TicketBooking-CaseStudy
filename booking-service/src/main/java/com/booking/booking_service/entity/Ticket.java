package com.booking.booking_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity 
@Table(name = "TICKET")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tkt_seq")
    @SequenceGenerator(name = "tkt_seq", sequenceName = "ticket_id_seq", allocationSize = 1)
    @Column(name = "TICKET_ID")
    private Long ticketId;

    @Column(name = "BOOKING_ID")
    private Long bookingId;

    @Column(name = "SEAT_ID")
    private String seatId;

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public Ticket(Long ticketId, Long bookingId, String seatId) {
		this.ticketId = ticketId;
		this.bookingId = bookingId;
		this.seatId = seatId;
	}

	public Ticket() {
	}
    
    
}
