package com.bezy.school_system.controllers;

import com.bezy.school_system.dtos.*;
import com.bezy.school_system.entities.*;
import com.bezy.school_system.mappers.*;
import com.bezy.school_system.repositories.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalTime;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final ResultRepository resultRepository;
    private final ExamRepository examRepository;
    private final ExamMapper examMapper;
    private final SubjectRepository subjectRepository;
    private final AssignmentRepository assignmentRepository;
    private final TeacherRepository teacherRepository;
    private final AssignmentMapper assignmentMapper;
    private final TeacherMapper teacherMapper;
    private final ResultMapper resultMapper;
    private EventRepository eventRepository;
    private EventMapper eventMapper;

    public TeacherController(ResultRepository resultRepository,
                             ExamRepository examRepository,
                             ExamMapper examMapper,
                             SubjectRepository subjectRepository,
                             AssignmentRepository assignmentRepository,
                             TeacherRepository teacherRepository,
                             AssignmentMapper assignmentMapper,
                             ResultMapper resultMapper,
                             TeacherMapper teacherMapper,
                             EventRepository eventRepository,
                             EventMapper eventMapper) {
        this.resultRepository = resultRepository;
        this.examRepository = examRepository;
        this.examMapper = examMapper;
        this.subjectRepository = subjectRepository;
        this.assignmentRepository = assignmentRepository;
        this.teacherRepository = teacherRepository;
        this.assignmentMapper = assignmentMapper;
        this.resultMapper = resultMapper;
        this.teacherMapper = teacherMapper;
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @PostMapping("/results")
    public ResponseEntity<?> createResultSlip(
            @RequestBody RegisterResultRequest request,
            UriComponentsBuilder uriBuilder
    ){
        Result result = new Result();
        result.setMarks(request.getMarks());
        result.setGrade(request.getGrade());
        result.setStatus(request.getStatus());
        resultRepository.save(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/results")
    public Iterable<?> getAllResults(
            ResultDto resultDto
    ){
        return resultRepository.findAll()
                .stream()
                .map(resultMapper::toDto)
                .toList();
    }

    @GetMapping("/results/{id}")
    public ResponseEntity<ResultDto> getResultSlipById(
            @PathVariable Long id
    ){
        var result = resultRepository.findById(id);
        if(result == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/results/{id}")
    public ResponseEntity<?> updateResultSlip(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateResultRequest request,
            UriComponentsBuilder uriBuilder
    ){
        var result = resultRepository.findById(request.getId()).orElse(null);
        if(result == null){
            return ResponseEntity.notFound().build();
        }

        resultMapper.update(request, result);
        resultRepository.save(result);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/results/{id}")
    public ResponseEntity<ResultDto> removeResultSlipById(
            @PathVariable Long id
    ){
        var result = resultRepository.findById(id).orElse(null);
        if(result == null){
            return ResponseEntity.notFound().build();
        }
        resultRepository.delete(result);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/exams")
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


    @GetMapping("/exams/{startTime}")
    public Iterable<?> getAllExamByStartTime(
            @RequestBody RegisterExamRequest request
            ){
        return examRepository.findByStartTime(request.getStartTime())
                .stream()
                .map(examMapper::toDto)
                .toList();
    }

    @GetMapping("/exams/{endTime}")
    public Iterable<?> getAllExamByEndTime(
            @RequestBody RegisterExamRequest request
    ){
        return examRepository.findByEndTime(request.getEndTime())
                .stream()
                .map(examMapper::toDto)
                .toList();
    }

    @GetMapping("/exams/{examDate}")
    public Iterable<?> getAllByExamDate(
            @RequestBody RegisterExamRequest request
    ){
        return examRepository.findByExamDate(request.getExamDate())
                .stream()
                .map(examMapper::toDto)
                .toList();
    }


    @GetMapping("/exams/subjectName")
    public Iterable<?> getAllBySubjectName(
            @RequestBody RegisterExamRequest request
    ){
        return examRepository.findExamBySubjectName(request.getSubjectName())
                .stream()
                .map(examMapper::toDto)
                .toList();
    }

    @PostMapping("/assignments")
    public ResponseEntity<?> createAssignment(
            @RequestBody RegisterAssignmentRequest request,
            Teacher teacher,
            Subject subject,
            UriComponentsBuilder uriBuilder
    ){
        Assignment assignment = new Assignment();
        assignment.setId(request.getId());
        assignment.setTeacher(request.getTeacher());
        assignment.setSubject(subject);
        assignment.setTeacher(teacher);
        assignment.setDueDate(request.getDueDate());
        assignmentRepository.save(assignment);

        return ResponseEntity.ok(assignment);
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<?> updateAssignmentById(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateAssignmentRequest request
    ){
        var assignment = assignmentRepository.findById(request.getId()).orElse(null);
        if(assignment == null){
            return ResponseEntity.notFound().build();
        }

        assignmentMapper.update(request, assignment);
        assignmentRepository.save(assignment);

        return ResponseEntity.ok(assignmentMapper.toDto(assignment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAssignmentById(
            @PathVariable Long id
    ){
        var assignment = assignmentRepository.findById(id).orElse(null);
        if(assignment == null){
            return ResponseEntity.notFound().build();
        }
        assignmentRepository.delete(assignment);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Iterable<?> getAllTeachers(
            TeacherDto teacherDto
    ){
        return teacherRepository.findAll()
                .stream()
                .map(teacher -> teacherMapper.toDto(teacher))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(
            @PathVariable Long id
    ){
        var teacher =  teacherRepository.findById(id).orElse(null);
        if(teacher == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/events")
    public Iterable<EventDto> getAllEvents(){
        return eventRepository.findAll()
                .stream()
                .map(event -> eventMapper.toDto(event))
                .toList();
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<EventDto> getEventById(
            @PathVariable Long id
    ){
        var event = eventRepository.findById(id).orElse(null);
        if(event == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(eventMapper.toDto(event));
    }
}
