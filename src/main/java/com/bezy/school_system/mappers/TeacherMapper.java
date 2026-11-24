package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.RegisterDepartmentRequest;
import com.bezy.school_system.dtos.TeacherDto;
import com.bezy.school_system.dtos.UpdateTeacherRequest;
import com.bezy.school_system.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDto toDto(Teacher teacher);
    @Mapping(target = "department", ignore = true)
    Teacher toEntity(RegisterDepartmentRequest request);
    void update(UpdateTeacherRequest request, @MappingTarget Teacher teacher);
}
