package com.bezy.school_system.dtos;

import lombok.Data;

import java.time.LocalTime;
import java.time.LocalDate;

@Data
public class UpdateEventRequest {
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;
    private String comments;
    private LocalDate date;

    public UpdateEventRequest(String title,
                              LocalTime startTime,
                              LocalTime endTime,
                              String comments,
                              LocalDate date) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.comments = comments;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
