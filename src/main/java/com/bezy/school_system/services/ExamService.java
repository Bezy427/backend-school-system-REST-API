package com.bezy.school_system.services;

import com.bezy.school_system.dtos.ExamDto;
import com.bezy.school_system.dtos.RegisterExamRequest;
import com.bezy.school_system.entities.Exam;
import com.bezy.school_system.entities.Subject;
import com.bezy.school_system.mappers.ExamMapper;
import com.bezy.school_system.repositories.ExamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ExamService {
    private ExamMapper examMapper;
    private ExamRepository examRepository;

    public ExamService(ExamMapper examMapper, ExamRepository examRepository) {
        this.examMapper = examMapper;
        this.examRepository = examRepository;
    }

    public ResponseEntity<?> createExam(
            @RequestBody RegisterExamRequest request,
            Subject subject
    ){
        Exam exam = new Exam();
        exam.setExamDate(request.getExamDate());
        exam.setStartTime(request.getStartTime());
        exam.setEndTime(request.getEndTime());
        exam.setPostpone(request.getPostPone());
        exam.setSubject(subject);
        examRepository.save(exam);
        return ResponseEntity.ok(exam);
    }

    public Iterable<?> getAllBySubjectName(
            @RequestBody RegisterExamRequest request
    ){
        return examRepository.findExamBySubjectName(request.getSubjectName())
                .stream()
                .map(examMapper::toDto)
                .toList();
    }

    public Iterable<?> getAllExams(
    ){
        return examRepository.findAll()
                .stream()
                .map(exam -> examMapper.toDto(exam))
                .toList();
    }
}
