package com.bezy.school_system.dtos;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class ExamDto {
    private Long id;
    private Long studentId;
    private LocalDate examDate;
    private String decision;
    private Time startTime;
    private Time endTime;
    private String postPone;

}

