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


}
