package com.bezy.school_system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "school_fees")
public class SchoolFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "history")
    private String history;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Column(name = "amount_due")
    private Double amountDue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    public SchoolFee(Long id,
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

    public SchoolFee() {}

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