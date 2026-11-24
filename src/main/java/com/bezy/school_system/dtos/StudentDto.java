package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Data
public class StudentDto {
    private Long id;

    @NotBlank(message = "First name is required!")
    @Pattern(regexp = "^[\\w\\s-]+$")
    private String firstName;


    private String lastName;
    private String email;
    private String registrationNumber;
    private String grade;
    private Date dateOfBirth;
    private String gender;
    private String parentContact;
    private User user_id;


    public StudentDto(User user_id, String parentContact, String gender, Date dateOfBirth, String grade, String registrationNumber, String email, String lastName, String firstName, Long id) {
        this.user_id = user_id;
        this.parentContact = parentContact;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.grade = grade;
        this.registrationNumber = registrationNumber;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
