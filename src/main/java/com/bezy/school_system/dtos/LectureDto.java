package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Teacher;
import lombok.Data;

import java.time.LocalTime;

@Data
public class LectureDto {
    private Long id;
    private String teacherName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String subjectName;
    private String location;
    private Teacher teacher;

}
