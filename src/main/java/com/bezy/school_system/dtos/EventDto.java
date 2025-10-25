package com.bezy.school_system.dtos;

import lombok.Data;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EventDto {
    private Long id;
    private String comments;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String title;

    public EventDto(Long id,
                    String comments,
                    LocalDate date,
                    LocalTime startTime,
                    LocalTime endTime,
                    String title
                    ) {
        this.id = id;
        this.comments = comments;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
