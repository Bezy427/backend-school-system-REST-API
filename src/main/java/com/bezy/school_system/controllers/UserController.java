package com.bezy.school_system.controllers;

import com.bezy.school_system.dtos.*;
import com.bezy.school_system.entities.*;
import com.bezy.school_system.mappers.*;
import com.bezy.school_system.repositories.*;
import com.bezy.school_system.services.StudentService;
import com.bezy.school_system.services.TeacherService;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.LogManager;
import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final LectureRepository lectureRepository;
    private final LectureMapper lectureMapper;
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;
    private final SchoolFeeRepository schoolFeeRepository;
    private final SchoolFeeMapper schoolFeeMapper;
    private final PaymentHistoryRepository paymentHistoryRepository;
    private final PaymentHistoryMapper paymentHistoryMapper;
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository,
                          UserMapper userMapper,
                          TeacherMapper teacherMapper,
                          TeacherRepository teacherRepository,
                          AttendanceMapper attendanceMapper,
                          StudentRepository studentRepository,
                          StudentMapper studentMapper,
                          StudentService studentService,
                          TeacherService teacherService,
                          AttendanceRepository attendanceRepository,
                          DepartmentRepository departmentRepository,
                          DepartmentMapper departmentMapper,
                          LectureRepository lectureRepository,
                          LectureMapper lectureMapper,
                          SubjectRepository subjectRepository,
                          SubjectMapper subjectMapper,
                          SchoolFeeRepository schoolFeeRepository,
                          SchoolFeeMapper schoolFeeMapper,
                          PaymentHistoryRepository paymentHistoryRepository,
                          PaymentHistoryMapper paymentHistoryMapper,
                          EventRepository eventRepository,
                          EventMapper eventMapper,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.attendanceRepository = attendanceRepository;
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
        this.attendanceMapper = attendanceMapper;
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
        this.lectureRepository = lectureRepository;
        this.lectureMapper = lectureMapper;
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
        this.schoolFeeRepository = schoolFeeRepository;
        this.schoolFeeMapper = schoolFeeMapper;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.paymentHistoryMapper = paymentHistoryMapper;
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/students")
    public Iterable<StudentDto> getAllStudents(
            @RequestParam(required = false, defaultValue = "") String sortBy
    ) {
        if(!Set.of("name", "email").contains(sortBy))
            sortBy = "name";

        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudent(
            @PathVariable Long id
    ){
        var student = studentRepository.findById(id).orElse(null);
        if(student == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentMapper.toDto(student));
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateTeacherRequest request
    ){
        var teacher = teacherRepository.findById(id).orElse(null);
        if(teacher == null){
            return ResponseEntity.notFound().build();
        }

        teacherMapper.update(request, teacher);
        teacherRepository.save(teacher);

        return ResponseEntity.ok(teacherMapper.toDto(teacher));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudent(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateStudentRequest request
    ){
        var student = studentRepository.findById(id).orElse(null);
        if(student == null){
            return ResponseEntity.notFound().build();
        }

        studentMapper.update(request, student);
        studentRepository.save(student);

        return ResponseEntity.ok(studentMapper.toDto(student));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable Long id
    ){
        studentRepository.deleteById(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }


    @PostMapping("/students")
    public ResponseEntity<?> createStudent(
            @Valid @RequestBody RegisterStudentRequest request,
            UriComponentsBuilder uriBuilder
    ){
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            return ResponseEntity.badRequest().body("Username already exists!");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists!");
        }

        studentService.createStudentAccount(request);
        return ResponseEntity.ok("Student account was created successfully!");
    }

    @PostMapping("/teachers")
    public ResponseEntity<?> createTeacher(
            @Valid @RequestBody RegisterTeacherRequest request,
            UriComponentsBuilder uriBuilder
    ){
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            return ResponseEntity.badRequest().body("Username already exists!");
        }

        if(userRepository.existsByEmail(request.getEmail())){
            return ResponseEntity.badRequest().body("Email already exists!");
        }

        teacherService.createTeacherAccount(request);
        return ResponseEntity.ok("Teacher account was created successfully!");
    }

    @GetMapping("/teachers")
    public Iterable<TeacherDto> getAllTeachers()
    {
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toDto)
                .toList();
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<?> getTeacher(
            @PathVariable Long id
    ){
        var teacher = teacherRepository.findById(id).orElse(null);
        if(teacher == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(teacherMapper.toDto(teacher));
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<TeacherDto> deleteTeacher(
            @PathVariable Long id
    ){
        var teacher = teacherRepository.findById(id).orElse(null);
        if(teacher == null){
            return ResponseEntity.notFound().build();
        }

        teacherRepository.delete(teacher);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/users")
    public Iterable<?> getAllUsers(
            StudentDto studentDto,
            TeacherDto teacherDto
    ){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(
            @PathVariable Long id){
        var user =  userRepository.findById(id).orElse(null);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @GetMapping("/students/attendances")
    public Iterable<?> getAttendanceByStudents(
            AttendanceDto attendanceDto
    ){
        return attendanceRepository.findAll()
                .stream()
                .map(attendanceMapper::toDto)
                .toList();
    }

    @PostMapping("/departments")
    public ResponseEntity<DepartmentDto> createDepartment(
            @RequestBody RegisterDepartmentRequest request
    ){
        Department department = new Department();
        department.setName(request.getName());
        department.setId(request.getId());
        department.setMembers(request.getMembers());
        department.setTeacher(request.getTeacher());
        departmentRepository.save(department);
        return ResponseEntity.ok(departmentMapper.toDto(department));
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<DepartmentDto> updateDepartmentById(
            @RequestBody UpdateDepartmentRequest request,
            @PathVariable Long id
    ){
        var department = departmentRepository.findById(id).orElse(null);
        if(department == null){
            return ResponseEntity.notFound().build();
        }

        departmentMapper.update(request, department);
        departmentRepository.save(department);
        return ResponseEntity.ok(departmentMapper.toDto(department));
    }

    @GetMapping("/departments")
    public List<DepartmentDto> getAllDepartments(
            
    ){
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toDto)
                .toList();
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<?> getDepartmentById(
            @PathVariable Long id
    ){
        var dep =  departmentRepository.findById(id).orElse(null);
        if(dep == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(departmentMapper.toDto(dep));
    }

    @GetMapping("/departments/name")
    public ResponseEntity<?> getDepartmentByName(
            String name
    ){
        var dep = departmentRepository.findDepartmentByName(name);
        if(dep == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departmentMapper.toDto(dep));
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<?> deleteDepartmentById(
            @PathVariable Long id
    ){
        var department = departmentRepository.findById(id).orElse(null);
        if(department == null){
            return ResponseEntity.notFound().build();
        }

        departmentRepository.delete(department);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/lectures")
    public ResponseEntity<?> registerLecture(
            @RequestBody RegisterLectureRequest request
    ){
        Lecture lecture = new Lecture();
        lecture.setId(request.getId());
        lecture.setStartTime(request.getStartTime());
        lecture.setEndTime(request.getEndTime());
        lecture.setLocation(request.getLocation());
        lecture.setTeacher(request.getTeacher());
        lecture.setTeacherName(request.getTeacherName());
        lecture.setSubjectName(request.getSubjectName());
        lectureRepository.save(lecture);
        return ResponseEntity.ok(lecture);
    }

    @GetMapping("/lectures")
    public Iterable<LectureDto> getAllLectures(
    ){
        return lectureRepository.findAll()
                .stream()
                .map(lectureMapper::toDto)
                .toList();
    }

    @PutMapping("/lectures/{id}")
    public ResponseEntity<LectureDto> updateLectureById(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateLectureRequest request
    ){
        var lecture = lectureRepository.findById(id).orElse(null);
        if(lecture == null){
            return ResponseEntity.notFound().build();
        }

        lectureMapper.update(request, lecture);
        lectureRepository.save(lecture);

        return ResponseEntity.ok(lectureMapper.toDto(lecture));
    }

    @GetMapping("/lectures/{id}")
    public ResponseEntity<LectureDto> getLectureById(
            @PathVariable Long id
    ){
        var lecture = lectureRepository.findById(id).orElse(null);
        if(lecture == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(lectureMapper.toDto(lecture));
    }

    @DeleteMapping("/lectures/{id}")
    public ResponseEntity<LectureDto> deleteLectureById(
            @PathVariable Long id
    ){
        var lecture = lectureRepository.findById(id).orElse(null);
        if(lecture == null){
            return ResponseEntity.notFound().build();
        }

        lectureRepository.delete(lecture);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/subjects")
    public ResponseEntity<?> createSubject(
            @RequestBody RegisterSubjectRequest request
    ){
        Subject subject = new Subject();
        subject.setId(request.getId());
        subject.setSubjectName(request.getSubjectName());
        subject.setDepartment(request.getDepartmentId());
        subjectRepository.save(subject);
        return ResponseEntity.ok(subject);
    }

    @GetMapping("/subjects")
    public Iterable<SubjectDto> getAllSubjects()
    {
        return subjectRepository.findAll()
                .stream()
                .map(subjectMapper::toDto)
                .toList();
    }

    @GetMapping("/subjects/{id}")
    public ResponseEntity<?> getSubjectById(
            @PathVariable Long id
    ){
        var subject = subjectRepository.findById(id).orElse(null);
        if(subject == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(subjectMapper.toDto(subject));
    }

    @PutMapping("/subjects/{id}")
    public ResponseEntity<?> updateSubject(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateSubjectRequest request
    ){
        var subject = subjectRepository.findById(id).orElse(null);
        if(subject == null){
            return ResponseEntity.notFound().build();
        }

        subjectMapper.update(request, subject);
        subjectRepository.save(subject);

        return ResponseEntity.ok(subjectMapper.toDto(subject));
    }

    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<?> deleteSubjectById(
            @PathVariable Long id
    ){
        var subject = subjectRepository.findById(id).orElse(null);
        if(subject == null){
            return ResponseEntity.notFound().build();
        }

        subjectRepository.delete(subject);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/school-fees")
    public ResponseEntity<?> createSchoolFeeStatement(
            RegisterSchoolFeeRequest request
    ){
        SchoolFee schoolFee = new SchoolFee();
        schoolFee.setId(request.getId());
        schoolFee.setBalance(request.getBalance());
        schoolFee.setPaymentDate(request.getPaymentDate());
        schoolFee.setAmountPaid(request.getAmountPaid());
        schoolFee.setAmountDue(request.getAmountDue());
        schoolFee.setStudent(request.getStudent());
        schoolFeeRepository.save(schoolFee);
        return ResponseEntity.ok(schoolFee);
    }

    @PutMapping("/school-fees/{id}")
    public ResponseEntity<?> updateSchoolFeeStatement(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateSchoolFeeRequest request
    ){
        var schoolFee = schoolFeeRepository.findById(request.getId()).orElse(null);
        if(schoolFee == null){
            return ResponseEntity.notFound().build();
        }

        schoolFeeMapper.update(request, schoolFee);
        schoolFeeRepository.save(schoolFee);

        return ResponseEntity.ok(schoolFeeMapper.toDto(schoolFee));
    }

    @GetMapping("/school-fees")
    public Iterable<SchoolFeeDto> getAllSchoolFeesStatement(
            @RequestBody RegisterSchoolFeeRequest request
    ){
        return schoolFeeRepository.findAll()
                .stream()
                .map(schoolFeeMapper::toDto)
                .toList();
    }

    @GetMapping("/school-fees/{id}")
    public ResponseEntity<SchoolFeeDto> getSchoolFeeByStudentId(
            @PathVariable Long id
    ){
        var school = schoolFeeRepository.findById(id).orElse(null);
        if(school == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(schoolFeeMapper.toDto(school));
    }

    @DeleteMapping("/school-fees/{id}")
    public ResponseEntity<Void> deleteSchoolFeeStatementById(
            @PathVariable Long id
    ){
        var schoolFee =  schoolFeeRepository.findById(id).orElse(null);
        if(schoolFee == null){
            return ResponseEntity.notFound().build();
        }

        schoolFeeRepository.delete(schoolFee);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/payment-history")
    public Iterable<?> getPaymentHistory(
            @RequestBody RegisterPaymentHistoryRequest request
    ){
        return paymentHistoryRepository.findAll()
                .stream()
                .map(paymentHistory -> paymentHistoryMapper.toDto(paymentHistory))
                .toList();
    }

    @GetMapping("/payment-history/{id}")
    public ResponseEntity<?> getPaymentHistoryById(
            @PathVariable Long id
    ){
        var paymentHistory = paymentHistoryRepository.findById(id).orElse(null);
        if(paymentHistory == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(paymentHistoryMapper.toDto(paymentHistory));
    }

    @PutMapping("/payment-history/{id}")
    public ResponseEntity<PaymentHistoryDto> updatePaymentHistoryById(
            @RequestBody UpdatePaymentHistoryRequest request,
            @PathVariable Long id,
            PaymentHistory paymentHistory
    ){
        var payment = paymentHistoryRepository.findById(id).orElse(null);
        if(payment == null){
            return ResponseEntity.notFound().build();
        }

        paymentHistoryMapper.update(request, paymentHistory);
        paymentHistoryRepository.save(payment);

        return ResponseEntity.ok(paymentHistoryMapper.toDto(payment));
    }

    @PostMapping("/events")
    public ResponseEntity<?> createEvent(
            @RequestBody RegisterEventRequest request
    ){
        Event event = new Event();
        event.setComments(request.getComments());
        event.setTitle(request.getTitle());
        event.setDate(request.getDate());
        event.setEndTime(request.getEndTime());
        event.setStartTime(request.getStartTime());
        event.setId(request.getId());
        eventRepository.save(event);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<?> updateEvent(
            @RequestBody UpdateEventRequest request,
            @PathVariable Long id
    ){
        var event = eventRepository.findById(id).orElse(null);
        if(event == null){
            return ResponseEntity.notFound().build();
        }

        eventMapper.update(request, event);

        eventRepository.save(event);
        return ResponseEntity.ok(event);
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

    @DeleteMapping("/events/{id}")
    public ResponseEntity<?> deleteEventById(
            @PathVariable Long id
    ){
        var event = eventRepository.findById(id).orElse(null);
        if(event == null){
            return ResponseEntity.notFound().build();
        }

        eventRepository.delete(event);
        return ResponseEntity.ok(event);
    }

}
