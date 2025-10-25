package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Department;
import com.bezy.school_system.entities.Subject;

public class SubjectDto {
    private Long id;
    private String subjectName;
    private Department departmentId;

    public SubjectDto(Long id, String subjectName, Department departmentId) {
        this.id = id;
        this.subjectName = subjectName;
        this.departmentId = departmentId;
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

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }
}
