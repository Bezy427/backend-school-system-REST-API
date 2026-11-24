package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Teacher;
import lombok.Data;

import java.util.List;

@Data
public class UpdateDepartmentRequest {
    private String name;
    private String members;
    private List<Teacher> teachers;

    public UpdateDepartmentRequest(String name,
                                   String members,
                                   List<Teacher> teachers) {
        this.name = name;
        this.members = members;
        this.teachers = teachers;
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

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeacher(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
