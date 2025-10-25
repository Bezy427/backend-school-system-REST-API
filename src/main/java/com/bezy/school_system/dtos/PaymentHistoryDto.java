package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Student;
import lombok.Data;

@Data
public class PaymentHistoryDto {
    private Long id;
    private Double balance;
    private Double amountPaid;
    private Double amountDue;
    private Student studentId;
}
