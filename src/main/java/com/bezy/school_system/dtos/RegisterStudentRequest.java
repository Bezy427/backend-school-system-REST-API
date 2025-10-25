package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Role;
import com.bezy.school_system.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    //(message = "Email must be lowercase!")
    private String email;

    @NotBlank(message = "Registration number is required!")
    private String registrationNumber;

    @NotBlank(message = "Password is required!")
    private String password;

    public RegisterStudentRequest(User user_id, String parentContact, String gender, LocalDate dateOfBirth, String grade, String username, String firstName, String lastName, String email, String registrationNumber, String password, Role role) {
        this.user_id = user_id;
        this.parentContact = parentContact;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.grade = grade;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registrationNumber = registrationNumber;
        this.password = password;
    }

    public RegisterStudentRequest() {
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getParentContact() {
        return parentContact;
    }

    public void setParentContact(String parentContact) {
        this.parentContact = parentContact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
