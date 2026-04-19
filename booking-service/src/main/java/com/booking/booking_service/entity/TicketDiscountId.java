package com.booking.booking_service.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TicketDiscountId implements Serializable {
    @Column(name = "DISCOUNT_ID")
    private String discountId;

    @Column(name = "TICKET_ID")
    private Long ticketId;

    // Default Constructor
    public TicketDiscountId() {}

    // All-args Constructor
    public TicketDiscountId(String discountId, Long ticketId) {
        this.discountId = discountId;
        this.ticketId = ticketId;
    }

    // Must implement equals() and hashCode() for composite keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketDiscountId)) return false;
        TicketDiscountId that = (TicketDiscountId) o;
        return Objects.equals(discountId, that.discountId) && 
               Objects.equals(ticketId, that.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountId, ticketId);
    }
}

