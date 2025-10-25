package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Teacher;
import lombok.Data;

import java.time.LocalTime;

@Data
public class LectureDto {
    private Long id;
    private String teacherName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String subjectName;
    private String location;
    private Teacher teacher;

    public LectureDto(Long id,
                      String teacherName,
                      LocalTime startTime,
                      LocalTime endTime,
                      String subjectName,
                      String location,
                      Teacher teacher) {
        this.id = id;
        this.teacherName = teacherName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.subjectName = subjectName;
        this.location = location;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
