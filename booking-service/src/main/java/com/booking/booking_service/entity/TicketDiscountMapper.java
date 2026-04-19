package com.booking.booking_service.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DISCOUNT_TICKET_MAPPER")
public class TicketDiscountMapper {

    @EmbeddedId
    private TicketDiscountId id;

    // Default Constructor
    public TicketDiscountMapper() {}

    // Convenience Constructor
    public TicketDiscountMapper(String discountId, Long ticketId) {
        this.id = new TicketDiscountId(discountId, ticketId);
    }

    public TicketDiscountId getId() { return id; }
    public void setId(TicketDiscountId id) { this.id = id; }
}
