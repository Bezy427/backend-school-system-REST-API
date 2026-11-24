package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Department;
import com.bezy.school_system.entities.Subject;
import lombok.Data;

@Data
public class UpdateSubjectRequest {
    private String subjectName;
    private Department departmentId;
}
