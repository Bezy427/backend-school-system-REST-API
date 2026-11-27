
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

import java.util.List;

@Service
public class TeacherService {

    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final TeacherMapper teacherMapper;
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;

    public TeacherService(
            UserRepository userRepository,
            TeacherMapper teacherMapper,
            TeacherRepository teacherRepository,
            PasswordEncoder passwordEncoder,
            DepartmentRepository departmentRepository
    ) {
        this.userRepository = userRepository;
        this.teacherMapper = teacherMapper;
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public Teacher createTeacherAccount(RegisterTeacherRequest request) {

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() ->
                        new RuntimeException("Department not found with ID: " + request.getDepartmentId()));

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User();
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(encodedPassword);
        user.setRole(Role.TEACHER);

        Teacher teacher = new Teacher();
        teacher.setUsername(request.getUsername());
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
        teacher.setPassword(encodedPassword);
        teacher.setPhoneNumber(request.getPhoneNumber());
        teacher.setRole(Role.TEACHER);
        teacher.setSubject(request.getSubject());
        teacher.setQualification(request.getQualification());
        teacher.setHireDate(request.getHireDate());
        teacher.setAddress(request.getAddress());
        teacher.setDepartment(department);
        teacher.setUser(user);

        user.setTeacher(teacher);

        department.setMembers(department.getMembers() + 1);
        department.addTeacher(teacher);

        userRepository.save(user);
        departmentRepository.save(department);

        return teacher;
    }

    @Transactional
    public ResponseEntity<TeacherDto> updateTeacherAccount(
            UpdateTeacherRequest request,
            Long id
    ) {
        var teacher = teacherRepository.findById(id).orElse(null);

        if (teacher == null) {
            return ResponseEntity.notFound().build();
        }

        teacherMapper.update(request, teacher);
        teacherRepository.save(teacher);

        return ResponseEntity.ok(teacherMapper.toDto(teacher));
    }

    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toDto)
                .toList();
    }

    public ResponseEntity<TeacherDto> getTeacherById(Long id) {
        var teacher = teacherRepository.findById(id).orElse(null);

        if (teacher == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(teacherMapper.toDto(teacher));
    }

    @Transactional
    public ResponseEntity<Void> deleteTeacherById(Long id) {
        var teacher = teacherRepository.findById(id).orElse(null);

        if (teacher == null) {
            return ResponseEntity.notFound().build();
        }

        Department department = teacher.getDepartment();

        if (department != null) {
            department.setMembers(Math.max(0, department.getMembers() - 1));
            department.getTeachers().remove(teacher);
        }

        teacherRepository.delete(teacher);

        return ResponseEntity.noContent().build();
    }
}
