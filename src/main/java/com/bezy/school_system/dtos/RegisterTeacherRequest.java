package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Role;
import com.bezy.school_system.entities.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterTeacherRequest {
    private User user_id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private String subject;
    private String qualification;
    private String department;
    private LocalDate hireDate;
    private String phoneNumber;
    private String address;

    public RegisterTeacherRequest(User user_id,
                                  String username,
                                  String firstName,
                                  String lastName,
                                  String email,
                                  String password,
                                  String confirmPassword,
                                  String phoneNumber,
                                  String subject,
                                  String qualification,
                                  String department,
                                  LocalDate hireDate,
                                  String address
    ) {
        this.user_id = user_id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.subject = subject;
        this.qualification = qualification;
        this.department = department;
        this.hireDate = hireDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setId(User user_id) {
        this.user_id = user_id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
