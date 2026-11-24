package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterPaymentHistoryRequest {
    private Long id;

    @NotBlank(message = "Balance must be provided!")
    private Double balance;

    @NotBlank(message = "Amount due is required!")
    private Double amountDue;

    @NotBlank(message = "Amount paid is required!")
    private Double amountPaid;

    private Student studentId;
}
