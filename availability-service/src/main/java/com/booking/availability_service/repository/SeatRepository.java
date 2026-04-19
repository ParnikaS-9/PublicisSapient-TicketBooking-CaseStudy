package com.booking.availability_service.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.availability_service.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, String> {
	
	List<Seat> findByScreenIdAndStatus(String screenId, String status);

	List<Seat> findAllById(Iterable<String> ids);
}
