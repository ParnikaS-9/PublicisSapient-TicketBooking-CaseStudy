package com.booking.theatre_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.booking.theatre_service.entity.Seat;

@Repository public interface SeatRepository extends JpaRepository<Seat, String> {}
