package com.booking.booking_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.booking_service.dto.BookingRequest;
import com.booking.booking_service.entity.Booking;
import com.booking.booking_service.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<String> book(@RequestBody BookingRequest req) {
        return ResponseEntity.ok(bookingService.createBooking(req));
    }

    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<String> cancel(@PathVariable String bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok("Booking Cancelled");
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBooking(@PathVariable String bookingId) {
        return ResponseEntity.ok(bookingService.getById(bookingId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable String userId) {
        return ResponseEntity.ok(bookingService.getByUser(userId));
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<String>> bulkBook(@RequestBody List<BookingRequest> reqs) {
        return ResponseEntity.ok(reqs.stream().map(bookingService::createBooking).collect(Collectors.toList()));
    }

    @DeleteMapping("/bulk-cancel")
    public ResponseEntity<String> bulkCancel(@RequestBody List<String> bookingIds) {
        bookingIds.forEach(bookingService::cancelBooking);
        return ResponseEntity.ok("Bulk Cancellation Processed");
    }
}