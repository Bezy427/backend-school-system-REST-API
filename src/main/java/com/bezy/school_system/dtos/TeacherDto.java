package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Department;
import com.bezy.school_system.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TeacherDto {
    private Long id;
    private User user_id;

    @NotBlank(message = "Username is required!")
    private String username;

    @NotBlank(message = "First name is required!")
    @Pattern(regexp = "^[\\w\\s-]+$")
    private String firstName;

    @NotBlank(message = "Last name is required!")
    private String lastName;

    @Email
    @NotBlank(message = "Email is required!")
    private String email;

    @NotBlank(message = "Password is required!")
    private String password;
    private String confirmPassword;
    private String subject;
    private String qualification;
    private LocalDate hireDate;
    private String phoneNumber;
    private String role;
    private String address;
    private Department department;

    public TeacherDto(Long id,
                      User user_id,
                      String username,
                      String firstName,
                      String lastName,
                      String email,
                      String password,
                      String confirmPassword,
                      String subject,
                      String qualification,
                      LocalDate hireDate,
                      String role,
                      String address,
                      Department department) {
        this.id = id;
        this.user_id = user_id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.subject = subject;
        this.qualification = qualification;
        this.hireDate = hireDate;
        this.role = role;
        this.address = address;
        this.department = department;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
