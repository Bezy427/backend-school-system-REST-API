package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.DepartmentDto;
import com.bezy.school_system.dtos.RegisterDepartmentRequest;
import com.bezy.school_system.dtos.TeacherDto;
import com.bezy.school_system.dtos.UpdateDepartmentRequest;
import com.bezy.school_system.entities.Department;
import com.bezy.school_system.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDto toDto(Department department);
    Department toEntity(RegisterDepartmentRequest request);
    void update(UpdateDepartmentRequest request, @MappingTarget Department department);
}
