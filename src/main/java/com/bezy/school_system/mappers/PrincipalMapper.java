package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.UpdatePrincipalRequest;
import com.bezy.school_system.entities.Principal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PrincipalMapper {
    Principal toDto(Principal principal);
    void update(UpdatePrincipalRequest request, @MappingTarget Principal principal);
}
