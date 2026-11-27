
package com.bezy.school_system.dtos;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterTeacherRequest {

    @NotBlank(message = "Username is required!")
    private String username;

    @NotBlank(message = "First name is required!")
    private String firstName;

    @NotBlank(message = "Last name is required!")
    private String lastName;

    @Email
    @NotBlank(message = "Email is required!")
    private String email;

    @NotBlank(message = "Password is required!")
    private String password;

    @NotBlank(message = "Confirm password is required!")
    private String confirmPassword;

    @AssertTrue(message = "Passwords do not match")
    public boolean isPasswordsMatching() {
        return password != null
                && password.equals(confirmPassword);
    }

    private String subject;
    private String qualification;
    private LocalDate hireDate;
    private String phoneNumber;
    private String address;

    @NotNull(message = "Department is required!")
    private Long departmentId;
}
