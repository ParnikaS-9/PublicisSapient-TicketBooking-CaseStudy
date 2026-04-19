package com.booking.showSchedule_service.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.showSchedule_service.service.ShowScheduleService;
import com.booking.showSchedule_service.dto.*;

@RestController
@RequestMapping("/api/v1/browse")
public class ShowScheduleController {

    @Autowired
    private ShowScheduleService showScheduleService;

    @GetMapping("/shows")
    public ResponseEntity<List<ShowDetailsResponse>> getAvailableShows(
            @RequestParam String movieId,
            @RequestParam String city,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
    	System.out.println("## "  + date); 
        List<ShowDetailsResponse> results = showScheduleService.getTheatresAndScreens(movieId, city, date);
        System.out.println("** "  + date);
        
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(results);
    }
}
