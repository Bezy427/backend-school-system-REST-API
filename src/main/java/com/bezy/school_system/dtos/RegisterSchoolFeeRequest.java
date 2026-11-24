package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterSchoolFeeRequest {
    private Long id;

    @NotBlank(message = "Balance is required!")
    private Double balance;

    @NotBlank(message = "Payment date is required!")
    private LocalDateTime paymentDate;

    @NotBlank(message = "History is required!")
    private String history;

    @NotBlank(message = "Amount paid must be provided!")
    private Double amountPaid;

    @NotBlank(message = "Amount due must be provided!")
    private Double amountDue;

    @NotBlank(message = "A student must be provided!")
    private Student student;

    public RegisterSchoolFeeRequest(Long id,
                                    Double balance,
                                    LocalDateTime paymentDate,
                                    String history,
                                    Double amountPaid,
                                    Double amountDue,
                                    Student student) {
        this.id = id;
        this.balance = balance;
        this.paymentDate = paymentDate;
        this.history = history;
        this.amountPaid = amountPaid;
        this.amountDue = amountDue;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(Double amountDue) {
        this.amountDue = amountDue;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
