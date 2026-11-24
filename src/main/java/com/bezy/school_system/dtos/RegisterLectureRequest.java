package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Teacher;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalTime;

@Data
public class RegisterLectureRequest {
    private Long id;

    @NotBlank(message = "Start time must be provided!")
    private LocalTime startTime;
    private LocalTime endTime;
    private String teacherName;
    private String subjectName;
    private String location;
    private Teacher teacher;

    public RegisterLectureRequest(Long id,
                                  LocalTime startTime,
                                  LocalTime endTime,
                                  String subjectName,
                                  String teacherName,
                                  String location,
                                  Teacher teacher) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.location = location;
        this.teacher = teacher;
    }

    public RegisterLectureRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
