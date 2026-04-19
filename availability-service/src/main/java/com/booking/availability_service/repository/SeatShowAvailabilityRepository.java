package com.booking.availability_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.availability_service.entity.SeatShowAvailability;
import com.booking.availability_service.entity.SeatShowId;

import jakarta.transaction.Transactional;

@Repository
public interface SeatShowAvailabilityRepository extends JpaRepository<SeatShowAvailability, SeatShowId> {

    /**
     * Requirement: Update availability status ('A' or 'B')
     * @Modifying is required for UPDATE/DELETE queries
     */
    @Modifying
    @Transactional
    @Query("UPDATE SeatShowAvailability s SET s.availability = :status " +
           "WHERE s.id.seatId = :seatId AND s.id.showScheduleId = :showId")
    int updateSeatStatus(@Param("seatId") String seatId, 
                         @Param("showId") String showId, 
                         @Param("status") String status);

    /**
     * Requirement 1: Find all available seats for a show
     */
    List<SeatShowAvailability> findByIdShowScheduleIdAndAvailability(String showScheduleId, String availability);

    /**
     * Requirement 2: Find specific seats for a show to build the name map
     */
    List<SeatShowAvailability> findByIdShowScheduleIdAndIdSeatIdIn(String showScheduleId, List<String> seatIds);
}

