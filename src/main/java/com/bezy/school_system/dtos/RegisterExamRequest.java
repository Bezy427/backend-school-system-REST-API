package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Decision;
import com.bezy.school_system.entities.PostPone;
import com.bezy.school_system.entities.Subject;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class RegisterExamRequest {
    private Long id;
    private String subjectName;
    private LocalDate examDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private PostPone postPone;

    public RegisterExamRequest(LocalDate examDate,
                               Long id,
                               String subjectName,
                               LocalTime startTime,
                               LocalTime endTime,
                               PostPone postPone) {
        this.examDate = examDate;
        this.id = id;
        this.subjectName = subjectName;
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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubject(String subjectName) {
        this.subjectName = subjectName;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }


    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public PostPone getPostPone() {
        return postPone;
    }
    public void setPostPone(PostPone postPone) {
        this.postPone = postPone;
    }

}
