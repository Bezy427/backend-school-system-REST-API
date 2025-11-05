package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Subject;
import com.bezy.school_system.entities.Teacher;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AssignmentDto {
    private Long id;
    private LocalDateTime dueDate;
    private Teacher teacher;
    private Subject subject;



}
