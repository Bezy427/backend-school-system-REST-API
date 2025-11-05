package com.bezy.school_system.services;

import com.bezy.school_system.controllers.ExamController;
import com.bezy.school_system.dtos.RegisterPaymentHistoryRequest;
import com.bezy.school_system.dtos.UpdatePaymentHistoryRequest;
import com.bezy.school_system.entities.PaymentHistory;
import com.bezy.school_system.mappers.AssignmentMapper;
import com.bezy.school_system.mappers.PaymentHistoryMapper;
import com.bezy.school_system.repositories.PaymentHistoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PaymentHistoryService {
    private PaymentHistoryRepository paymentHistoryRepository;
    private PaymentHistoryMapper paymentHistoryMapper;

    public ResponseEntity<?> updatePaymentHistoryById(
            @PathVariable Long id,
            PaymentHistory paymentHistory,
            @RequestBody UpdatePaymentHistoryRequest request
    ){
        var payment = paymentHistoryRepository.findById(id).orElse(null);
        if(payment == null){
            return ResponseEntity.notFound().build();
        }

        paymentHistoryMapper.update(request, paymentHistory);
        paymentHistoryRepository.save(payment);
        return  ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getPaymentHistoryById(
            @PathVariable Long id
    ){
        var paymentHistory = paymentHistoryRepository.findById(id).orElse(null);
        if(paymentHistory == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(paymentHistoryMapper.toDto(paymentHistory));
    }

    public Iterable<?> getPaymentHistory(
            @PathVariable Long id
    ) {
        return paymentHistoryRepository.findAll()
                .stream()
                .map(paymentHistory -> paymentHistoryMapper.toDto(paymentHistory))
                .toList();
    }
}
