package com.booking.showSchedule_service.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.showSchedule_service.entity.ShowSchedule;

@Repository
public interface ShowScheduleRepository extends JpaRepository<ShowSchedule, String> {

    @Query("SELECT ss FROM ShowSchedule ss " +
           "JOIN Fetch ss.screen s " +
           "JOIN Fetch s.theatre t " +
           "WHERE ss.movieId = :movieId " +
           "AND t.city = :city " +
           "AND ss.movieDate = :date")
    

    List<ShowSchedule> findShowsByMovieCityAndDate(
            @Param("movieId") String movieId, 
            @Param("city") String city, 
            @Param("date") LocalDate date);
}
