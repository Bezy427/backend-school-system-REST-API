package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Status;
import lombok.Data;
import org.w3c.dom.Text;

@Data
public class UpdateResultRequest {
    private Long id;
    private String marks;
    private String grade;
    private Status status;

    public UpdateResultRequest(Long id,
                               String marks,
                               String grade,
                               Status status) {
        this.id = id;
        this.marks = marks;
        this.grade = grade;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
