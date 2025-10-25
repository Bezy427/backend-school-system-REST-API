package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.StudentDto;
import com.bezy.school_system.dtos.UpdateStudentRequest;
import com.bezy.school_system.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);
    void update(UpdateStudentRequest request, @MappingTarget Student student);

}
