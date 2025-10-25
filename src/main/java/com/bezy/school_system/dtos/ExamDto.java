package com.bezy.school_system.dtos;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ExamDto {
    private Long id;
    private Long studentId;
    private LocalDate examDate;
    private String decision;
    private Time startTime;
    private Time endTime;
    private String postPone;

    public ExamDto(Long id,
                   Long studentId,
                   LocalDate examDate,
                   String decision,
                   Time startTime,
                   Time endTime,
                   String postPone) {
        this.id = id;
        this.studentId = studentId;
        this.examDate = examDate;
        this.decision = decision;
        this.startTime = startTime;
        this.endTime = endTime;
        this.postPone = postPone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudent_id(Long studentId) {
        this.studentId = studentId;
    }

    public LocalDate getExam_date() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Time getStart_time() {
        return startTime;
    }

    public void setStart_time(Time startTime) {
        this.startTime = startTime;
    }
}
