package com.booking.availability_service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.availability_service.entity.SeatShowAvailability;
import com.booking.availability_service.service.AvailabilityService;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    /**
     * Requirement 1: Returns list of available seats for a specific show.
     * GET /availability/show/{showScheduleId}
     */
    @GetMapping("/show/{showScheduleId}")
    public ResponseEntity<List<SeatShowAvailability>> getAvailableSeats(@PathVariable String showScheduleId) {
        List<SeatShowAvailability> availableSeats = availabilityService.getAvailableByShow(showScheduleId);
        return ResponseEntity.ok(availableSeats);
    }

    /**
     * Requirement 2: Returns a map of Seat_Name (Row_Num) and its availability status.
     * GET /availability/map/{showScheduleId}?seatIds=S1,S2,S3
     */
    @GetMapping("/map/{showScheduleId}")
    public ResponseEntity<Map<String, String>> getSeatAvailabilityMap(
            @PathVariable String showScheduleId,
            @RequestParam List<String> seatIds) {
        
        Map<String, String> seatMap = availabilityService.getSeatMap(showScheduleId, seatIds);
        return ResponseEntity.ok(seatMap);
    }
    
    @PatchMapping("/update-status")
    public ResponseEntity<Void> updateStatus(
            @RequestParam String seatId,
            @RequestParam String showId,
            @RequestParam String status) {
        
        availabilityService.updateStatusInDb(seatId, showId, status);
        return ResponseEntity.ok().build();
    }
}
