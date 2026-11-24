package com.bezy.school_system.controllers;

import com.bezy.school_system.dtos.*;
import com.bezy.school_system.entities.*;
import com.bezy.school_system.mappers.ExamMapper;
import com.bezy.school_system.repositories.*;
import com.bezy.school_system.services.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final ResultRepository resultRepository;
    private final ExamRepository examRepository;
    private final TeacherRepository teacherRepository;
    private final AssignmentService assignmentService;
    private final TeacherService teacherService;
    private final EventService eventService;
    private final ExamService examService;
    private final ResultSlipService resultSlipService;
    private final EventRepository eventRepository;
    private final PrincipalService principalService;
    private final ExamMapper examMapper;

    @PostMapping("/results")
    public ResponseEntity<?> createResultSlip(
            @RequestBody RegisterResultRequest request,
            UriComponentsBuilder uriBuilder
    ){
        resultSlipService.createResultSlip(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/results")
    public Iterable<?> getAllResults(
            ResultDto resultDto
    ){
       resultSlipService.getAllResults();
       return resultRepository.findAll();
    }

    @GetMapping("/results/{id}")
    public ResponseEntity<ResultDto> getResultSlipById(
            @PathVariable Long id
    ){
        resultSlipService.getResultById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/results/{id}")
    public ResponseEntity<?> updateResultSlip(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateResultRequest request,
            UriComponentsBuilder uriBuilder
    ){
        resultSlipService.updateResultById(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/results/{id}")
    public ResponseEntity<ResultDto> deleteResultSlipById(
            @PathVariable Long id
    ){
        resultSlipService.deleteResultById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/exams")
    public ResponseEntity<?> createExam(
            @RequestBody RegisterExamRequest request,
            Subject subject
    ){
        examService.createExam(request, subject);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/exams")
    public Iterable<?> getAllExams(
    ){
        return examRepository.findAll()
                .stream()
                .map(exam -> examMapper.toDto(exam))
                .toList();
    }

    @GetMapping("/exams/{id}")
    public ResponseEntity<?> getAllById(
            @PathVariable Long id
    ){
       var exam = examRepository.findById(id).orElse(null);
       if(exam == null){
           return ResponseEntity.notFound().build();
       }

       return ResponseEntity.ok().body(exam);
    }

    @PostMapping("/assignments")
    public ResponseEntity<?> createAssignment(
            @RequestBody RegisterAssignmentRequest request,
            Teacher teacher,
            Subject subject,
            UriComponentsBuilder uriBuilder
    ){
        assignmentService.createAssignment(request, subject, teacher);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<?> updateAssignmentById(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateAssignmentRequest request
    ){
        assignmentService.updateAssignmentById(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<?> deleteAssignmentById(
            @PathVariable Long id
    ){
        assignmentService.deleteAssignmentById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Iterable<Teacher> getAllTeachers(
    ){
        teacherService.getAllTeachers();
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(
            @PathVariable Long id
    ){
        teacherService.deleteTeacherById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/events")
    public Iterable<?> getAllEvents(){
       eventService.getAllEvents();
       return eventRepository.findAll();
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<EventDto> getEventById(
            @PathVariable Long id
    ){
        eventService.getEventById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<PrincipalDto> getPrincipal(){
        principalService.getPrincipal();
        return ResponseEntity.ok().build();
    }
}
