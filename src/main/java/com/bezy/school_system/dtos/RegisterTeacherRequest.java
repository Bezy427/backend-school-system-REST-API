package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Department;
import com.bezy.school_system.entities.User;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
public class RegisterTeacherRequest {
    private User user_id;
    private String username;
    private String firstName;
    private String lastName;

    @Email
    @NotBlank(message = "email is required!")
    private String email;

    @NotBlank(message = "password is required!")
    private String password;

    @NotBlank(message = "Confirm password is required!")
    private String confirmPassword;

    @AssertTrue(message = "Passwords do not match")
    public boolean isPasswordsMatching() {
        return password != null && password.equals(confirmPassword);
    }
    private String subject;
    private String qualification;
    private LocalDate hireDate;
    private String phoneNumber;
    private String address;
    private Department department;

}
