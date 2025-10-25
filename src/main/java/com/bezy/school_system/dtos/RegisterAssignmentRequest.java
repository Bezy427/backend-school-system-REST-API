package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Subject;
import com.bezy.school_system.entities.Teacher;

import java.time.LocalDateTime;

public class RegisterAssignmentRequest {
    private Long id;
    private LocalDateTime dueDate;
    private Teacher teacher;
    private Subject subject;

    public RegisterAssignmentRequest(Long id,
                                     LocalDateTime dueDate,
                                     Teacher teacher,
                                     Subject subject) {
        this.id = id;
        this.dueDate = dueDate;
        this.teacher = teacher;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
