package com.booking.theatre_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;
import com.booking.theatre_service.entity.Fare;
import com.booking.theatre_service.entity.Seat;
import com.booking.theatre_service.entity.ShowSchedule;
import com.booking.theatre_service.repository.FareRepository;
import com.booking.theatre_service.repository.SeatRepository;
import com.booking.theatre_service.repository.ShowScheduleRepository;
import jakarta.transaction.Transactional;

@Service
public class TheatreService {
    @Autowired private ShowScheduleRepository showRepo;
    @Autowired private SeatRepository seatRepo;
    @Autowired private FareRepository fareRepo;

    @Transactional
    public ShowSchedule createShow(ShowSchedule show) {
        return showRepo.save(show);
    }

    public void deleteShow(String showId) {
        showRepo.deleteById(showId);
    }

    @Transactional
    public List<Seat> allocateInventory(String fareId, List<Seat> seats) {
    	Fare fare = fareRepo.findById(fareId).orElseThrow();
    	for (Seat seat : seats) {
            seat.setFare(fare);
            // Hibernate now sees isNew() = true and runs SQL INSERT
        }
        return seatRepo.saveAll(seats);
    }

    @Transactional
    public Seat updateSeatStatus(String seatId, String status) {
        Seat seat = seatRepo.findById(seatId).orElseThrow();
        seat.setStatus(status);
        return seatRepo.save(seat);
    }
}