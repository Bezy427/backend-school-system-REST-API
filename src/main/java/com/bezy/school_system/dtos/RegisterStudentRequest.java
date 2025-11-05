package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.User;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class RegisterStudentRequest {
    private User user_id;

    @NotBlank(message = "Parent contact is required!")
    private String parentContact;

    @NotBlank(message = "Gender is required!")
    private String gender;

    private LocalDate dateOfBirth;

    @NotBlank(message = "Grade is required!")
    private String grade;

    @NotBlank(message = "Username is required!")
    @Pattern(regexp = "^[\\w\\s-]+$")
    private String username;

    @NotBlank(message = "First name is required!")
    @Pattern(regexp = "^[\\w\\s-]+$")
    private String firstName;

    @NotBlank(message = "Last name is required!")
    @Pattern(regexp = "^[\\w\\s-]+$")
    private String lastName;

    @Email(message = "Email must be valid!")
    @NotBlank(message = "Email is required!")
    private String email;

    @NotBlank(message = "Registration number is required!")
    private String registrationNumber;

    @NotBlank(message = "Password is required!")
    private String password;

    @NotBlank(message = "Confirm password is required!")
    private String confirmPassword;

    @AssertTrue(message = "Passwords do not match")
    public boolean isPasswordsMatching() {
        return password != null && password.equals(confirmPassword);
    }
}
