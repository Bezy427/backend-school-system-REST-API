
package com.bezy.school_system.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;

    @NotBlank(message = "First name is required!")
    @Pattern(regexp = "^[\\w\\s-]+$")
    private String firstName;

    private String lastName;
    private String email;
    private String registrationNumber;
    private String grade;
    private LocalDate dateOfBirth;
    private String gender;
    private String parentContact;

    // Only expose the associated user's ID, never the complete User entity.
    private Long userId;
}
