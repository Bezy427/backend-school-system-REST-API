package com.bezy.school_system.services;

import com.bezy.school_system.dtos.RegisterTeacherRequest;
import com.bezy.school_system.dtos.TeacherDto;
import com.bezy.school_system.dtos.UpdateTeacherRequest;
import com.bezy.school_system.entities.Department;
import com.bezy.school_system.entities.Role;
import com.bezy.school_system.entities.Teacher;
import com.bezy.school_system.entities.User;
import com.bezy.school_system.mappers.TeacherMapper;
import com.bezy.school_system.repositories.DepartmentRepository;
import com.bezy.school_system.repositories.TeacherRepository;
import com.bezy.school_system.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TeacherService {
    private final DepartmentRepository departmentRepository;
    private UserRepository userRepository;
    private TeacherMapper teacherMapper;
    private TeacherRepository teacherRepository;
    private PasswordEncoder passwordEncoder;

    public TeacherService(UserRepository userRepository,
                          TeacherMapper teacherMapper,
                          TeacherRepository teacherRepository,
                          PasswordEncoder passwordEncoder,
                          DepartmentRepository departmentRepository) {
        this.userRepository = userRepository;
        this.teacherMapper = teacherMapper;
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public Teacher createTeacherAccount(RegisterTeacherRequest request, Long departmentId){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(Role.TEACHER);


        Teacher teacher = new Teacher();
        teacher.setId(user.getId());
        teacher.setUsername(request.getUsername());
        teacher.setLastName(request.getLastName());
        teacher.setFirstName(request.getFirstName());
        teacher.setPassword(passwordEncoder.encode(request.getPassword()));
        teacher.setEmail(request.getEmail());
        teacher.setRole(Role.TEACHER);
        teacher.setSubject(request.getSubject());
        teacher.setQualification(request.getQualification());
        teacher.setHireDate(request.getHireDate());
        teacher.setAddress(request.getAddress());
        teacher.setDepartment(request.getDepartment());
        teacher.setUser(user);
        user.setTeacher(teacher);
        Department dept = departmentRepository.findById(teacher.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found!"));
        dept.setMembers(dept.getMembers() + 1);
        dept.addTeacher(teacher);
        userRepository.save(user);
        departmentRepository.save(dept);
        return teacher;
    }

    public ResponseEntity<TeacherDto> updateTeacherAccount(
            @RequestBody UpdateTeacherRequest request,
            @PathVariable Long id
    ){
        var teacher = teacherRepository.findById(id).orElse(null);
        if(teacher == null){
            return ResponseEntity.notFound().build();
        }

        teacherMapper.update(request, teacher);
        teacherRepository.save(teacher);
        return ResponseEntity.ok().body(teacherMapper.toDto(teacher));
    }

    public void getAllTeachers(
            ) {
        teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toDto)
                .toList();
    }

    public ResponseEntity<TeacherDto> deleteTeacherById(
            @PathVariable Long id
    ){
        var teacher =  teacherRepository.findById(id).orElse(null);
        if(teacher == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(teacherMapper.toDto(teacher));
    }
}
