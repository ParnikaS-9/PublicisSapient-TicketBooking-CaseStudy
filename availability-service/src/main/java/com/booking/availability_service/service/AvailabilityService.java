package com.booking.availability_service.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.availability_service.entity.SeatShowAvailability;
import com.booking.availability_service.repository.AvailabilityRepository;
import com.booking.availability_service.repository.SeatShowAvailabilityRepository;

import jakarta.transaction.Transactional;

@Service
public class AvailabilityService {
    @Autowired private AvailabilityRepository repo;
    @Autowired private SeatShowAvailabilityRepository seatShowRepo;

    public List<SeatShowAvailability> getAvailableByShow(String showId) {
        return repo.findByIdShowScheduleId(showId).stream()
                   .filter(a -> "A".equals(a.getAvailability()))
                   .collect(Collectors.toList());
    }

    public Map<String, String> getSeatMap(String showId, List<String> seatIds) {
        return repo.findByIdShowScheduleIdAndIdSeatIdIn(showId, seatIds).stream()
            .collect(Collectors.toMap(
                a -> a.getSeat().getScreenRow() + "_" + a.getSeat().getSeatNum(),
                SeatShowAvailability::getAvailability
            ));
    }
    
    @Transactional
    public void updateStatusInDb(String seatId, String showId, String status) {
        // Uses the @Modifying query from the repository we created earlier
        int updatedRows = seatShowRepo.updateSeatStatus(seatId, showId, status);
        
        if (updatedRows == 0) {
            throw new RuntimeException("Seat mapping not found for update");
        }
    }
}
