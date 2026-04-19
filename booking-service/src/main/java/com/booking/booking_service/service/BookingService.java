package com.booking.booking_service.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.booking.booking_service.dto.BookingRequest;
import com.booking.booking_service.entity.Booking;
import com.booking.booking_service.entity.Ticket;
import com.booking.booking_service.entity.TicketDiscountMapper;
import com.booking.booking_service.repository.BookingRepository;
import com.booking.booking_service.repository.DiscountMapperRepository;
import com.booking.booking_service.repository.TicketRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.transaction.Transactional;

@Service
public class BookingService {
    @Autowired private BookingRepository bookingRepo;
    @Autowired private TicketRepository ticketRepo;
    @Autowired private DiscountMapperRepository discountRepo;
    @Autowired private WebClient webClient;

    @CircuitBreaker(name = "availService", fallbackMethod = "handleFallback")
    @Retry(name = "availService")
    @Transactional
    public String createBooking(BookingRequest req) {
        // 1. Fetch Availability using WebClient
        Map<String, String> statusMap = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/availability/map/{showId}")
                        .queryParam("seatIds", String.join(",", req.getSeatIds()))
                        .build(req.getShowScheduleId()))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {})
                .block(); // Blocking for transactional consistency

        // 2. Validation
        List<String> unavailable = req.getSeatIds().stream()
                .filter(id -> !"A".equals(statusMap.get(id)))
                .collect(Collectors.toList());

        if (!unavailable.isEmpty()) {
            return "Following seat id not available: " + unavailable;
        }

        // 3. Save Booking (Sequence: booking_id_seq)
        Booking booking = new Booking();
        booking.setMovieId(req.getMovieId());
        booking.setUserId(req.getUserId());
        booking.setShowSchdId(req.getShowScheduleId());
        booking = bookingRepo.save(booking);

        // 4. Save Tickets & Mark status 'B'
        for (String sId : req.getSeatIds()) {
            Ticket ticket = new Ticket();
            ticket.setBookingId(booking.getBookingId());
            ticket.setSeatId(sId);
            ticket = ticketRepo.save(ticket); // Sequence: ticket_id_seq

            if (req.getDiscountId() != null) {
                discountRepo.save(new TicketDiscountMapper(req.getDiscountId(), ticket.getTicketId()));
            }

            // 5. Update status via WebClient Patch
            updateAvailabilityStatus(sId, req.getShowScheduleId(), "B");
        }

        return "Booking Successful. ID: " + booking.getBookingId();
    }

    private void updateAvailabilityStatus(String seatId, String showId, String status) {
        webClient.patch()
                .uri(uriBuilder -> uriBuilder
                        .path("/availability/update-status")
                        .queryParam("seatId", seatId)
                        .queryParam("showId", showId)
                        .queryParam("status", status)
                        .build())
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public String handleFallback(BookingRequest req, Exception e) {
        return "Booking failed: Availability service unreachable.";
    }
    
    public Booking getById(Long bookingId) {
        return bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking ID not found"));
    }

    // Requirement 4: Show all bookings for a user
    public List<Booking> getByUser(String userId) {
        return bookingRepo.findByUserId(userId);
    }

	public Booking getById(String bookingId) {
		// TODO Auto-generated method stub
		return getById(Long.parseLong(bookingId));
	}
	
	@Transactional
    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        List<Ticket> tickets = ticketRepo.findByBookingId(bookingId);

        for (Ticket t : tickets) {
            discountRepo.deleteByTicketId(t.getTicketId());
            updateAvailabilityStatus(t.getSeatId(), booking.getShowSchdId(), "A");
            ticketRepo.delete(t);
        }
        bookingRepo.delete(booking);
    }

	public void cancelBooking(String bookingId) {
		 cancelBooking(Long.parseLong(bookingId));
	}
}
