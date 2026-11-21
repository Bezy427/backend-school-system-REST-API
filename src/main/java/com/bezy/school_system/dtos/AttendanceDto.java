package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Attendance;
import com.bezy.school_system.entities.Status;
import com.bezy.school_system.entities.Student;
import com.bezy.school_system.entities.Subject;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Data
public class AttendanceDto {
    private Long id;
    private Student studentId;
    private Subject subjectId;
    private LocalDate date;
    private Status status;


}
