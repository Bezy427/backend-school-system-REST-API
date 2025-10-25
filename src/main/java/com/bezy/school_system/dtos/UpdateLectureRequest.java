package com.bezy.school_system.dtos;

import lombok.Data;

import java.time.LocalTime;

@Data
public class UpdateLectureRequest {
    private LocalTime startTime;
    private LocalTime endTime;
    private String subjectName;
    private String teacherName;
    private String location;

    public UpdateLectureRequest(LocalTime startTime,
                                LocalTime endTime,
                                String subjectName,
                                String teacherName,
                                String location) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.location = location;
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
}
