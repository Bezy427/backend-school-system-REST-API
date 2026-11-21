package com.bezy.school_system.controllers;

import com.bezy.school_system.dtos.AttendanceDto;
import com.bezy.school_system.dtos.EnrollmentDto;
import com.bezy.school_system.entities.Status;
import com.bezy.school_system.mappers.EnrollmentMapper;
import com.bezy.school_system.repositories.EnrollmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    private EnrollmentMapper enrollmentMapper;
    private EnrollmentRepository enrollmentRepository;

    @GetMapping
    public Iterable<EnrollmentDto> getAllEnrollments(
            @RequestBody AttendanceDto attendanceDto
    ){
        return enrollmentRepository.findAll()
                .stream()
                .map(enrollment -> enrollmentMapper.toDto(enrollment))
                .toList();
    }


}
