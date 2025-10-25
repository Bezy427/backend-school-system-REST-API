package com.bezy.school_system.repositories;

import com.bezy.school_system.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> id(Long id);
}