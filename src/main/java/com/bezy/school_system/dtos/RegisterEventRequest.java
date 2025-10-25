package com.bezy.school_system.dtos;

import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class RegisterEventRequest {
    private Long id;
    private String comments;
    private String title;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public RegisterEventRequest(Long id,
                                String comments,
                                String title,
                                LocalDate date,
                                LocalTime startTime,
                                LocalTime endTime
    ) {
        this.id = id;
        this.comments = comments;
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
}
