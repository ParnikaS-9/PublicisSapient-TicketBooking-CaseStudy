package com.booking.availability_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.availability_service.entity.SeatShowAvailability;
import com.booking.availability_service.entity.SeatShowId;

public interface AvailabilityRepository extends JpaRepository<SeatShowAvailability, SeatShowId> {
    List<SeatShowAvailability> findByIdShowScheduleId(String showScheduleId);
    List<SeatShowAvailability> findByIdShowScheduleIdAndIdSeatIdIn(String showScheduleId, List<String> seatIds);
}
