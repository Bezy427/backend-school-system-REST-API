package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Role;
import com.bezy.school_system.entities.Student;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class RegisterUserRequest {
    private String username;

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String registrationNumber;

    private String password;

    private Role role;

    private String confirmPassword;

    private Long studentId;


    public RegisterUserRequest(String username, String firstName, String lastName, String email, String registrationNumber, String password, Role role, String confirmPassword, Long studentId) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registrationNumber = registrationNumber;
        this.password = password;
        this.role = role;
        this.confirmPassword = confirmPassword;
        this.studentId = studentId;
    }

    public RegisterUserRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
