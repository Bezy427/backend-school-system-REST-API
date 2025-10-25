package com.bezy.school_system.services;

import com.bezy.school_system.dtos.RegisterTeacherRequest;
import com.bezy.school_system.dtos.TeacherDto;
import com.bezy.school_system.entities.Role;
import com.bezy.school_system.entities.Teacher;
import com.bezy.school_system.entities.User;
import com.bezy.school_system.mappers.StudentMapper;
import com.bezy.school_system.mappers.TeacherMapper;
import com.bezy.school_system.repositories.TeacherRepository;
import com.bezy.school_system.repositories.UserRepository;
import com.fasterxml.jackson.core.Base64Variant;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private UserRepository userRepository;
    private TeacherMapper teacherMapper;
    private TeacherRepository teacherRepository;
    private PasswordEncoder passwordEncoder;

    public TeacherService(UserRepository userRepository,
                          TeacherMapper teacherMapper,
                          TeacherRepository teacherRepository,
                          PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.teacherMapper = teacherMapper;
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Teacher createTeacherAccount(RegisterTeacherRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(Role.TEACHER);

        Teacher teacher = new Teacher();
        teacher.setUsername(request.getUsername());
        teacher.setLastName(request.getLastName());
        teacher.setFirstName(request.getFirstName());
        teacher.setPassword(request.getPassword());
        teacher.setEmail(request.getEmail());
        teacher.setRole(Role.TEACHER);
        teacher.setSubject(request.getSubject());
        teacher.setDepartment(request.getDepartment());
        teacher.setQualification(request.getQualification());
        teacher.setHireDate(request.getHireDate());
        teacher.setAddress(request.getAddress());
        teacher.setUser(user);
        user.setTeacher(teacher);
        userRepository.save(user);
        return teacher;
    }
}
