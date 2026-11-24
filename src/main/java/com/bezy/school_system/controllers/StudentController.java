package com.bezy.school_system.controllers;

import com.bezy.school_system.dtos.*;
import com.bezy.school_system.entities.Role;
import com.bezy.school_system.entities.SchoolFee;
import com.bezy.school_system.mappers.*;
import com.bezy.school_system.repositories.*;
import com.bezy.school_system.services.LectureService;
import com.bezy.school_system.services.PrincipalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final UserRepository userRepository;
    private final SchoolFeeRepository schoolFeeRepository;
    private final EventRepository eventRepository;
    private final ExamRepository examRepository;
    private final LectureRepository lectureRepository;
    private final LectureService lectureService;
    private final PrincipalService principalService;
    private SchoolFeeMapper schoolFeeMapper;
    private EventMapper eventMapper;
    private ExamMapper examMapper;
    private LectureMapper lectureMapper;

    public StudentController(StudentRepository studentRepository,
                             StudentMapper studentMapper,
                             UserRepository userRepository,
                             SchoolFeeRepository schoolFeeRepository,
                             EventRepository eventRepository,
                             EventMapper eventMapper,
                             ExamRepository examRepository,
                             ExamMapper examMapper,
                             LectureRepository lectureRepository,
                             LectureMapper lectureMapper, LectureService lectureService, PrincipalService principalService) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.userRepository = userRepository;
        this.schoolFeeRepository = schoolFeeRepository;
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.examRepository = examRepository;
        this.schoolFeeMapper = schoolFeeMapper;
        this.examMapper = examMapper;
        this.lectureRepository = lectureRepository;
        this.lectureMapper = lectureMapper;
        this.lectureService = lectureService;
        this.principalService = principalService;
    }

    @GetMapping
    public Iterable<StudentDto> getAllStudents(StudentDto studentDto){
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(
            @PathVariable Long id
    ){
        var student = studentRepository.findById(id).orElse(null);
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentMapper.toDto(student));
    }

    @GetMapping("/school-fees")
    public Iterable<SchoolFeeDto> getAllSchoolFee(){
        return schoolFeeRepository.findAll()
                .stream()
                .map(schoolFee -> schoolFeeMapper.toDto(schoolFee))
                .toList();
    }

    @GetMapping("/school-fees/balance")
    public ResponseEntity<?> getSchoolFeeByBalance(
            @PathVariable Double balance
    ){
        var fees = schoolFeeRepository.findSchoolFeesByBalance(balance);
        if(fees == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(fees);
    }

    @GetMapping("/school-fees/paymentDate")
    public ResponseEntity<?> getSchoolFeeByPaymentDate(
            @PathVariable LocalDateTime paymentDate
    ){
        var date = schoolFeeRepository.findSchoolFeesByPaymentDate(paymentDate);
        if(date == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(date);
    }

    @GetMapping("/events")
    public Iterable<EventDto> getAllEvents(
    ){
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

    @GetMapping("/exams")
    public Iterable<?> getAllExams(
            @RequestBody RegisterExamRequest request
    ){
        return examRepository.findAll()
                .stream()
                .map(exam -> examMapper.toDto(exam))
                .toList();
    }

    @GetMapping("/exams/{id}")
    public ResponseEntity<?> getExamById(
            @PathVariable Long id
    ){
        var exam = examRepository.findById(id).orElse(null);
        if(exam == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(exam);
    }

    @GetMapping("/lectures")
    public ResponseEntity<LectureDto> getAllLectures(
            @PathVariable Long id
    ){
        lectureService.getAllLecture(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<PrincipalDto> getPrincipal(){
        principalService.getPrincipal();
        return ResponseEntity.ok().build();
    }
}
