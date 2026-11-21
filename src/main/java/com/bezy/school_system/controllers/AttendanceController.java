package com.bezy.school_system.controllers;

import com.bezy.school_system.dtos.AttendanceDto;
import com.bezy.school_system.entities.Attendance;
import com.bezy.school_system.mappers.AttendanceMapper;
import com.bezy.school_system.repositories.AttendanceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.ClassUtils.isPresent;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {
    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;

    public AttendanceController(AttendanceRepository attendanceRepository, AttendanceMapper attendanceMapper) {
        this.attendanceRepository = attendanceRepository;
        this.attendanceMapper = attendanceMapper;
    }

    @GetMapping
    public Iterable<AttendanceDto> getAllAttendance(Attendance attendance){
        return attendanceRepository.findAll()
                .stream()
                .map(attendanceMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendanceDto> getAttendance(
            @PathVariable Long id
    ){
        var student = attendanceRepository.findById(id).orElse(null);
        if(student == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(attendanceMapper.toDto(student));
    }
}
