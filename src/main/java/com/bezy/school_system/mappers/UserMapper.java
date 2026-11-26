
package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.RegisterUserRequest;
import com.bezy.school_system.dtos.UserDto;
import com.bezy.school_system.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(RegisterUserRequest request);
}
