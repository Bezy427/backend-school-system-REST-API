package com.bezy.school_system.repositories;

import com.bezy.school_system.dtos.SchoolFeeDto;
import com.bezy.school_system.dtos.StudentDto;
import com.bezy.school_system.entities.SchoolFee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SchoolFeeRepository extends JpaRepository<SchoolFee, Long> {
    List<SchoolFeeDto> findSchoolFeesByBalance(Double balance);
    List<SchoolFeeDto> findSchoolFeesByPaymentDate(LocalDateTime paymentDate);

    Long id(Long id);
}