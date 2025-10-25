package com.bezy.school_system.mappers;

import com.bezy.school_system.entities.Principal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrincipalMapper {
    Principal toDto(Principal principal);
}
