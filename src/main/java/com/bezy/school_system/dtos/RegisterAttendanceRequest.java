package com.bezy.school_system.dtos;


import com.bezy.school_system.entities.Status;
import com.bezy.school_system.entities.Student;
import com.bezy.school_system.entities.Subject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
public class RegisterAttendanceRequest {
    private Long id;
    private Student studentId;
    private Subject subjectId;
    private LocalDate date;
    private Status status;

}
