package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.PaymentHistoryDto;
import com.bezy.school_system.dtos.RegisterPaymentHistoryRequest;
import com.bezy.school_system.dtos.UpdatePaymentHistoryRequest;
import com.bezy.school_system.entities.PaymentHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaymentHistoryMapper {
    PaymentHistoryDto toDto(PaymentHistory paymentHistory);
    PaymentHistory toEntity(RegisterPaymentHistoryRequest request);
    void update(UpdatePaymentHistoryRequest request, @MappingTarget PaymentHistory paymentHistory);

}
