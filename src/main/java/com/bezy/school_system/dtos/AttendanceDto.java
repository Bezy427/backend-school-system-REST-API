package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Attendance;
import com.bezy.school_system.entities.Status;
import com.bezy.school_system.entities.Student;
import com.bezy.school_system.entities.Subject;
import lombok.Data;

import java.util.Date;

@Data
public class AttendanceDto {
    private Long id;
    private Student studentId;
    private Subject subjectId;
    private Date date;
    private Status status;

    public AttendanceDto(Long id, Student studentId, Subject subjectId, Date date, Status status) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
