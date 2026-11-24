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

}
