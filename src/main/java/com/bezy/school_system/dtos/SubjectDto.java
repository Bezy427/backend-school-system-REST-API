package com.bezy.school_system.dtos;

public class SubjectDto {
    private Long id;
    private String subjectName;
    private Long departmentId;

    public SubjectDto(Long id, String subjectName, Long departmentId) {
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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}