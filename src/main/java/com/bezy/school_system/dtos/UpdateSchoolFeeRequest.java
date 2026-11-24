package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Student;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateSchoolFeeRequest {
    private Long id;
    private Double amountPaid;
    private String history;
    private Double balance;
    private Double amountDue;
    private Student student;
    private LocalDateTime paymentDate;

    public UpdateSchoolFeeRequest(Long id,
                                  Double amountPaid,
                                  String history,
                                  Double balance,
                                  Double amountDue,
                                  Student student,
                                  LocalDateTime paymentDate) {
        this.id = id;
        this.amountPaid = amountPaid;
        this.history = history;
        this.balance = balance;
        this.amountDue = amountDue;
        this.student = student;
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}
