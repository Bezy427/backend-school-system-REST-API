package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterResultRequest {
    private Long id;

    @NotBlank(message = "Marks must be provided!")
    private String marks;

    @NotBlank(message = "Grade must be provided!")
    private String grade;

    @NotBlank(message = "Status must be provided!")
    private Status status;

    public RegisterResultRequest(Long id,
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
