package com.bezy.school_system.services;

import com.bezy.school_system.dtos.RegisterStudentRequest;
import com.bezy.school_system.dtos.StudentDto;
import com.bezy.school_system.entities.Role;
import com.bezy.school_system.entities.Student;
import com.bezy.school_system.entities.User;
import com.bezy.school_system.mappers.StudentMapper;
import com.bezy.school_system.repositories.StudentRepository;
import com.bezy.school_system.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final PasswordEncoder passwordEncoder;

    public StudentService(UserRepository userRepository,
                          StudentRepository studentRepository,
                          StudentMapper studentMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public Student createStudentAccount(RegisterStudentRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
       user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.STUDENT);

        Student student = new Student();
        student.setUsername(request.getUsername());
        student.setLastName(request.getLastName());
        student.setFirstName(request.getFirstName());
        student.setEmail(request.getEmail());
        student.setRole(Role.STUDENT);
        student.setGender(request.getGender());
        student.setRegistrationNumber(request.getRegistrationNumber());
        student.setParentContact(request.getParentContact());
        student.setGrade(request.getGrade());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setUser(user);
        user.setStudent(student);
        userRepository.save(user);
        return student;
    }
}
