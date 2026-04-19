package com.booking.booking_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.booking_service.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    /**
     * Requirement 2: Find all tickets to release seats during cancellation.
     */
    List<Ticket> findByBookingId(Long bookingId);

    /**
     * Used for bulk operations if needed.
     */
    void deleteByBookingId(Long bookingId);
}
