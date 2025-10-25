package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.TeacherDto;
import com.bezy.school_system.dtos.UpdateTeacherRequest;
import com.bezy.school_system.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDto toDto(Teacher teacher);
    void update(UpdateTeacherRequest request, @MappingTarget Teacher teacher);
}
