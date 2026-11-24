package com.bezy.school_system.services;

import com.bezy.school_system.dtos.RegisterSchoolFeeRequest;
import com.bezy.school_system.dtos.UpdateSchoolFeeRequest;
import com.bezy.school_system.entities.SchoolFee;
import com.bezy.school_system.mappers.SchoolFeeMapper;
import com.bezy.school_system.repositories.SchoolFeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SchoolFeesServices {
    private SchoolFeeRepository schoolFeeRepository;
    private SchoolFeeMapper schoolFeeMapper;

    public SchoolFee createSchoolFee(
            @RequestBody RegisterSchoolFeeRequest request
    ){
        SchoolFee schoolFee = new SchoolFee();
        schoolFee.setId(request.getId());
        schoolFee.setBalance(request.getBalance());
        schoolFee.setPaymentDate(request.getPaymentDate());
        schoolFee.setAmountPaid(request.getAmountPaid());
        schoolFee.setAmountDue(request.getAmountDue());
        schoolFee.setStudent(request.getStudent());
        schoolFeeRepository.save(schoolFee);
        return schoolFee;
    }

    public Iterable<?> getAllSchoolFeesStatement(
            ){
        return schoolFeeRepository.findAll()
                .stream()
                .map(schoolFeeMapper::toDto)
                .toList();
    }

    public ResponseEntity<?> updateSchoolFee(
            @PathVariable Long id,
            @RequestBody UpdateSchoolFeeRequest request
    ){
        var schoolFee = schoolFeeRepository.findById(request.getId()).orElse(null);
        if(schoolFee == null){
            return ResponseEntity.notFound().build();
        }

        schoolFeeMapper.update(request, schoolFee);
        schoolFeeRepository.save(schoolFee);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteSchoolFee(
            @PathVariable Long id
    ){
        var schoolFee =  schoolFeeRepository.findById(id).orElse(null);
        if(schoolFee == null){
            return ResponseEntity.notFound().build();
        }

        schoolFeeRepository.delete(schoolFee);
        return ResponseEntity.ok().build();
    }
}
