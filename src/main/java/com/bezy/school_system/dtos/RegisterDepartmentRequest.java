package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Teacher;
import lombok.Data;

@Data
public class RegisterDepartmentRequest {
    private Long id;
    private String name;
    private String members;
    private Teacher teacher;

    public RegisterDepartmentRequest(Long id,
                                     String name,
                                     String members,
                                     Teacher teacher) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
