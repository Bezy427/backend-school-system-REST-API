package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Teacher;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentDto {
    private Long id;
    private String name;
    private int members;
    private Teacher teacherId;

}
