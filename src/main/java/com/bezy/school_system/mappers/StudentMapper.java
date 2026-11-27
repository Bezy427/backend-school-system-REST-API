
package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.StudentDto;
import com.bezy.school_system.dtos.UpdateStudentRequest;
import com.bezy.school_system.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "user.id", target = "userId")
    StudentDto toDto(Student student);

    void update(UpdateStudentRequest request, @MappingTarget Student student);
}
