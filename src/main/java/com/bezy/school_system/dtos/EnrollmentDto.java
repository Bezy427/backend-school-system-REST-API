package com.bezy.school_system.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnrollmentDto {
    private Long id;
    private LocalDate dateIssued;
    private Long studentId;
    private Long subjectId;
    private String academicYear;
    private String form;
    private String prevResults;
    private String prevSchool;
}
