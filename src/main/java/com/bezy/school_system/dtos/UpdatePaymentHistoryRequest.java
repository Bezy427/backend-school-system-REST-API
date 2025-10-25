package com.bezy.school_system.dtos;

import lombok.Data;

@Data
public class UpdatePaymentHistoryRequest {
    private Double balance;
    private Double amountPaid;

    public UpdatePaymentHistoryRequest(Double balance,
                                       Double amountPaid) {
        this.balance = balance;
        this.amountPaid = amountPaid;
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
}
