package com.booking.theatre_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.theatre_service.entity.Seat;
import com.booking.theatre_service.entity.ShowSchedule;
import com.booking.theatre_service.service.TheatreService;

@RestController
@RequestMapping("/api/theatre")
public class TheatreController {
    @Autowired private TheatreService theatreService;

    // --- Show Management ---
    @PostMapping("/shows")
    public ResponseEntity<ShowSchedule> addShow(@RequestBody ShowSchedule show) {
        return ResponseEntity.ok(theatreService.createShow(show));
    }

    @DeleteMapping("/shows/{id}")
    public ResponseEntity<Void> removeShow(@PathVariable String id) {
        theatreService.deleteShow(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/inventory/allocate/{fareId}")
    public ResponseEntity<List<Seat>> allocateSeats(@PathVariable String fareId, @RequestBody List<Seat> seats) {
        return ResponseEntity.ok(theatreService.allocateInventory(fareId, seats));
    }

    @PatchMapping("/inventory/seats/{seatId}")
    public ResponseEntity<Seat> updateSeat(@PathVariable String seatId, @RequestParam String status) {
        return ResponseEntity.ok(theatreService.updateSeatStatus(seatId, status));
    }
}
