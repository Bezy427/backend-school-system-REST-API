package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.PostPone;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class RegisterExamRequest {
    private Long id;
    private String subjectName;
    private LocalDate examDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private PostPone postPone;
}
