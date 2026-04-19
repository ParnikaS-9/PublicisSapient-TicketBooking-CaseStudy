package com.booking.theatre_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.theatre_service.entity.ShowSchedule;

@Repository public interface ShowScheduleRepository extends JpaRepository<ShowSchedule, String> {}