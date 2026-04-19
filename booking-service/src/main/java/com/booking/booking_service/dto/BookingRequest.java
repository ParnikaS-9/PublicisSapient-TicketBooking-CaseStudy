package com.booking.booking_service.dto;

import java.util.List;

public class BookingRequest {
    private String movieId;
    private String userId;
    private String showScheduleId;
    private List<String> seatIds;
    private String discountId; // Can be null

    // Standard Getters and Setters
    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public String getShowScheduleId() { return showScheduleId; }
    public void setShowScheduleId(String showScheduleId) { this.showScheduleId = showScheduleId; }
    
    public List<String> getSeatIds() { return seatIds; }
    public void setSeatIds(List<String> seatIds) { this.seatIds = seatIds; }
    
    public String getDiscountId() { return discountId; }
    public void setDiscountId(String discountId) { this.discountId = discountId; }
}
