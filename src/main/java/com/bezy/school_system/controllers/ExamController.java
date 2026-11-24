package com.bezy.school_system.controllers;

import com.bezy.school_system.entities.Exam;
import com.bezy.school_system.mappers.EnrollmentMapper;
import com.bezy.school_system.mappers.ExamMapper;
import com.bezy.school_system.repositories.ExamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {

    private final ExamRepository examRepository;
    private final ExamMapper examMapper;

    public ExamController(ExamRepository examRepository, ExamMapper examMapper) {
        this.examRepository = examRepository;
        this.examMapper = examMapper;
    }

    @GetMapping
    public Iterable<?> findAll() {
        return examRepository.findAll()
                .stream()
                .map(examMapper::toDto)
                .toList();
    }
}
