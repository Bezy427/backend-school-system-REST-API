package com.bezy.school_system.dtos;

import lombok.Data;
import java.time.LocalTime;

@Data
public class LectureDto {

    private Long id;

    private LocalTime startTime;

    private LocalTime endTime;

    private String subjectName;

    private String teacherName;

    private String location;

    private Long teacherId;
}