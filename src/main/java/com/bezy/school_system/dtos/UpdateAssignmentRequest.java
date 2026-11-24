package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Subject;
import com.bezy.school_system.entities.Teacher;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateAssignmentRequest {
    private Long id;
    private Subject subject;
    private Teacher teacher;
    private LocalDateTime dueDate;

    public UpdateAssignmentRequest(Long id,
                                   Subject subject,
                                   Teacher teacher,
                                   LocalDateTime dueDate) {
        this.id = id;
        this.subject = subject;
        this.teacher = teacher;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
