package com.booking.booking_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.booking_service.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    /**
     * Requirement 4: Show all bookings for a user.
     */
    List<Booking> findByUserId(String userId);

    /**
     * Requirement 3: Show booking data based on booking id.
     * (Inherited from JpaRepository as findById)
     */
}