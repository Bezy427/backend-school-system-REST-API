package com.bezy.school_system.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "payment_history")
public class PaymentHistory {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "balance", nullable = false)
    private Double balance;

    @NotNull
    @Column(name = "amount_paid", nullable = false)
    private Double amountPaid;

    @NotNull
    @Column(name = "payment_date", nullable = false)
    private Instant paymentDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public PaymentHistory(Long id, Double balance, Double amountPaid, Instant paymentDate, Student student) {
        this.id = id;
        this.balance = balance;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.student = student;
    }

    public PaymentHistory() {
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

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}