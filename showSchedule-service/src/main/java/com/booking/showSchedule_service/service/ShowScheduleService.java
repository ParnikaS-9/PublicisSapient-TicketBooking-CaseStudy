package com.booking.showSchedule_service.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.showSchedule_service.dto.ShowDetailsResponse;
import com.booking.showSchedule_service.entity.ShowSchedule;
import com.booking.showSchedule_service.repository.ShowScheduleRepository;

@Service
public class ShowScheduleService {

    @Autowired
    private ShowScheduleRepository showRepository;

    public List<ShowDetailsResponse> getTheatresAndScreens(String movieId, String city, LocalDate date) {
        List<ShowSchedule> schedules = showRepository.findShowsByMovieCityAndDate(movieId, city, date);
        System.out.println("++ "+schedules.size());
        // Map to a clean DTO to avoid sending internal entity details
        return schedules.stream().map(ss -> new ShowDetailsResponse(
                ss.getScreen().getTheatre().getTheatreName(),
                ss.getScreen().getScreenName(),
                ss.getMovieTime(),
                ss.getShowScheduleId()
        )).collect(Collectors.toList());
    }
}

