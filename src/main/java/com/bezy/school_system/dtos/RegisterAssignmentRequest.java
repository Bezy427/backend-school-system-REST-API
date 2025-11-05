package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Subject;
import com.bezy.school_system.entities.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class RegisterAssignmentRequest {
    private Long id;
    private LocalDateTime dueDate;
    private Teacher teacher;
    private Subject subject;

}
