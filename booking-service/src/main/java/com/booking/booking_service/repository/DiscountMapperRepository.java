package com.booking.booking_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.booking_service.entity.TicketDiscountId;
import com.booking.booking_service.entity.TicketDiscountMapper;

@Repository
public interface DiscountMapperRepository extends JpaRepository<TicketDiscountMapper, TicketDiscountId> {
    @Modifying
    @Query("DELETE FROM TicketDiscountMapper t WHERE t.id.ticketId = :ticketId")
    void deleteByTicketId(@Param("ticketId") Long ticketId);
}
