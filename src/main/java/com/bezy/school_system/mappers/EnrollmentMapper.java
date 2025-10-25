package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.EnrollmentDto;
import com.bezy.school_system.entities.Enrollment;
import com.bezy.school_system.entities.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    EnrollmentDto toDto(Enrollment enrollment);
}
