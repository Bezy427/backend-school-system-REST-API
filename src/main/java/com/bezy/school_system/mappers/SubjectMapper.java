package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.RegisterSubjectRequest;
import com.bezy.school_system.dtos.SubjectDto;
import com.bezy.school_system.dtos.UpdateSubjectRequest;
import com.bezy.school_system.entities.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectDto toDto(Subject subject);
    Subject toEntity(RegisterSubjectRequest request);

    Subject update(UpdateSubjectRequest request, Subject subject);
}
