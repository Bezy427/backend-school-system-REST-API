package com.bezy.school_system.controllers;

import com.bezy.school_system.dtos.*;
import com.bezy.school_system.entities.*;
import com.bezy.school_system.mappers.*;
import com.bezy.school_system.repositories.*;
import com.bezy.school_system.services.*;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


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
    private final SchoolFeesServices schoolFeesServices;
    private final EventService eventService;
    private final PaymentHistoryService paymentHistoryService;
    private final DepartmentService departmentService;
    private final LectureService lectureService;
    private final SubjectService subjectService;
    private final UserService userService;
    private final PrincipalService principalService;
    private final PrincipalRepository principalRepository;
    private final PrincipalMapper principalMapper;

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
                          PrincipalMapper principalMapper,
                          PasswordEncoder passwordEncoder,
                          SubjectService subjectService,
                          SchoolFeesServices schoolFeesServices,
                          EventService eventService,
                          PaymentHistoryService paymentHistoryService,
                          DepartmentService departmentService,
                          LectureService lectureService,
                          SubjectService subjectService1, UserService userService,
                          PrincipalService principalService, PrincipalRepository principalRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.principalMapper = principalMapper;
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
        this.schoolFeesServices = schoolFeesServices;
        this.eventService = eventService;
        this.paymentHistoryService = paymentHistoryService;
        this.departmentService = departmentService;
        this.lectureService = lectureService;
        this.subjectService = subjectService1;
        this.userService = userService;
        this.principalService = principalService;
        this.principalRepository = principalRepository;
    }

    @PostMapping("/principal")
    public ResponseEntity<?> createPrincipal(
           @Valid @RequestBody RegisterPrincipalRequest request,
           UriComponentsBuilder uriBuilder
    ){
        principalService.createPrincipal(request);
        return ResponseEntity.ok("Principal was created successfully!");
    }

    @PutMapping("/principal/{id}")
    public ResponseEntity<PrincipalDto> updatePrincipal(
            @RequestBody UpdatePrincipalRequest request,
            @PathVariable Long id
    ){
        var principal = principalRepository.findById(id).orElse(null);
        if(principal == null){
            return ResponseEntity.notFound().build();
        }
        principalMapper.update(request, principal);
        principalRepository.save(principal);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/principal")
    public Iterable<?> getPrincipalById(
    ){
        return principalRepository.findAll()
                .stream()
                .map(principal -> principalMapper.toDto(principal))
                .toList();
    }

    @GetMapping("/students")
    public Iterable<StudentDto> getAllStudents(
    ) {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(
            @PathVariable Long id
    ){
        var student = studentRepository.findById(id).orElse(null);
        if(student == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(studentMapper.toDto(student));

    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateTeacherRequest request
    ){
        teacherService.updateTeacherAccount(request, id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudent(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateStudentRequest request
    ){
        studentService.updateStudentAccount(request, id);

        return ResponseEntity.ok().build();
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
            @RequestParam Long departmentId
    ){
        if(userRepository.findByUsername(request.getUsername()).isPresent())
            return ResponseEntity.badRequest().body("Name already exists!");

        teacherService.createTeacherAccount(request, departmentId);
        return ResponseEntity.ok("Teacher account was created successfully!");
    }

    @GetMapping("/teachers")
    public Iterable<TeacherDto> getAllTeachers(
    )
    {
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toDto)
                .toList();
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<TeacherDto> getTeacher(
            @PathVariable Long id
    ){
        var teacher = teacherRepository.findById(id).orElse(null);
        if(teacher == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(teacherMapper.toDto(teacher));
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<?> deleteTeacher(
            @PathVariable Long id
    ){
        teacherRepository.deleteById(id);
        return ResponseEntity.ok("Teacher was successfully deleted!");
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
            @PathVariable(name="id") Long id){
        var user =  userRepository.findById(id).orElse(null);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @GetMapping("/attendance/{id}")
    public ResponseEntity<AttendanceDto> getAttendanceById(
            @PathVariable Long id
    ){
        var attendance = attendanceRepository.findById(id).orElse(null);
        if(attendance == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(attendanceMapper.toDto(attendance));
    }

    @GetMapping("/attendances")
    public Iterable<?> getAllAttendance(){
        return attendanceRepository.findAll()
                .stream()
                .map(attendanceMapper::toDto)
                .toList();
    }

    @PostMapping("/attendances")
    public ResponseEntity<AttendanceDto> createAttendance(
            @RequestBody RegisterAttendanceRequest request
    ){
        Attendance attendance = new Attendance();
        attendance.setDate(request.getDate());
        attendance.setId(request.getId());
        attendance.setStudent(request.getStudentId());
        attendance.setSubject(request.getSubjectId());
        attendanceRepository.save(attendance);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/departments")
    public ResponseEntity<?> createDepartment(
            @RequestBody RegisterDepartmentRequest request
    ){
        Department department = new Department();
        department.setName(request.getName());
        department.setId(request.getId());
        department.setMembers(request.getMembers());
        departmentRepository.save(department);
        return ResponseEntity.ok("department was successfully created!");
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<?> updateDepartmentById(
            @RequestBody UpdateDepartmentRequest request,
            @PathVariable Long id
    ){
        departmentService.updateDepartmentById(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/departments")
    public Iterable<?> getAllDepartments(
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
        var dept = departmentRepository.findById(id).orElse(null);
        if(dept == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(departmentMapper.toDto(dept));
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<?> deleteDepartmentById(
            @PathVariable Long id
    ){
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/lectures")
    public ResponseEntity<?> registerLecture(
            @RequestBody RegisterLectureRequest request
    ){
        lectureService.createLecture(request);
        return ResponseEntity.ok().build();
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
        lectureService.updateLectureById(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/lectures/{id}")
    public ResponseEntity<LectureDto> getLectureById(
            @PathVariable Long id
    ){
        var lecture = lectureRepository.findById(id).orElse(null);
        if(lecture ==  null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lectureMapper.toDto(lecture));
    }

    @DeleteMapping("/lectures/{id}")
    public ResponseEntity<LectureDto> deleteLectureById(
            @PathVariable Long id
    ){
        lectureService.deleteLectureById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/subjects")
    public ResponseEntity<?> createSubject(
            @RequestBody RegisterSubjectRequest request
    ){
        subjectService.createSubject(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/subjects")
    public Iterable<?> getAllSubjects(
    )
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
        var subject =  subjectRepository.findById(id).orElse(null);
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
        subjectService.updateSubject(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<?> deleteSubjectById(
            @PathVariable Long id
    ){
        subjectService.deleteSubjectById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/school-fees")
    public ResponseEntity<?> createSchoolFeeStatement(
            RegisterSchoolFeeRequest request
    ){
        schoolFeesServices.createSchoolFee(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/school-fees/{id}")
    public ResponseEntity<?> updateSchoolFeeStatement(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateSchoolFeeRequest request
    ){
        schoolFeesServices.updateSchoolFee(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/school-fees")
    public ResponseEntity<?> getAllSchoolFeesStatement(
    ){
        schoolFeesServices.getAllSchoolFeesStatement();
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/school-fees/{id}")
    public ResponseEntity<Void> deleteSchoolFeeStatementById(
            @PathVariable Long id
    ){
        schoolFeesServices.deleteSchoolFee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/payment-history")
    public ResponseEntity<?> getPaymentHistory(
            @PathVariable Long id
    ){
        paymentHistoryService.getPaymentHistory(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/payment-history/{id}")
    public ResponseEntity<?> getPaymentHistoryById(
            @PathVariable Long id
    ){
        paymentHistoryService.getPaymentHistoryById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/payment-history/{id}")
    public ResponseEntity<PaymentHistoryDto> updatePaymentHistoryById(
            @RequestBody UpdatePaymentHistoryRequest request,
            @PathVariable Long id,
            PaymentHistory paymentHistory
    ){

        paymentHistoryService.updatePaymentHistoryById(id, paymentHistory, request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/events")
    public ResponseEntity<?> createEvent(
            @RequestBody RegisterEventRequest request
    ){
        eventService.createEvent(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<?> updateEvent(
            @RequestBody UpdateEventRequest request,
            @PathVariable(name = "id") Long id
    ){
        var event = eventRepository.findById(id).orElse(null);
        if(event == null){
            return ResponseEntity.noContent().build();
        }
        eventMapper.update(request, event);
        eventRepository.save(event);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/events")
    public Iterable<?> getAllEvents(
    ){
        eventService.getAllEvents();
        return eventRepository.findAll();
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
        eventService.deleteEventById(id);
        return ResponseEntity.ok().build();
    }

}
