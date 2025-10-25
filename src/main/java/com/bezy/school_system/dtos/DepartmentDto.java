package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Teacher;
import lombok.Data;

@Data
public class DepartmentDto {
    private Long id;
    private String name;
    private String members;
    private Teacher teacher_id;

    public DepartmentDto(Long id,
                         String name,
                         String members,
                         Teacher teacher_id) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.teacher_id = teacher_id;
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

    public Teacher getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Teacher teacher_id) {
        this.teacher_id = teacher_id;
    }
}
