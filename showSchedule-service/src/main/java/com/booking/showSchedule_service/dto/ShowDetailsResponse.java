package com.booking.showSchedule_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShowDetailsResponse {
    private String theatreName;
    private String screenName;
    private LocalDateTime showTime;
    private String showScheduleId;
	public ShowDetailsResponse(String theatreName, String screenName, LocalDateTime showTime, String showScheduleId) {
		super();
		this.theatreName = theatreName;
		this.screenName = screenName;
		this.showTime = showTime;
		this.showScheduleId = showScheduleId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public LocalDateTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}
	public String getShowScheduleId() {
		return showScheduleId;
	}
	public void setShowScheduleId(String showScheduleId) {
		this.showScheduleId = showScheduleId;
	}   
}
