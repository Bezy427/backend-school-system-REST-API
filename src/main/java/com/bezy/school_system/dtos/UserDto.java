
package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Role;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private Role role;

    public UserDto(Long id, String username, String email, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
