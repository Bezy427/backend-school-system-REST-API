package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Teacher;
import lombok.Data;

@Data
public class UpdateDepartmentRequest {
    private String name;
    private String members;
    private Teacher teacher;

    public UpdateDepartmentRequest(String name,
                                   String members,
                                   Teacher teacher) {
        this.name = name;
        this.members = members;
        this.teacher = teacher;
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
