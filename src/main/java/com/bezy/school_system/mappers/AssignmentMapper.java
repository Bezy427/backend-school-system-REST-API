package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.AssignmentDto;
import com.bezy.school_system.dtos.UpdateAssignmentRequest;
import com.bezy.school_system.entities.Assignment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {
    AssignmentDto toDto(Assignment assignment);
    void update(UpdateAssignmentRequest request, @MappingTarget Assignment assignment);
}
