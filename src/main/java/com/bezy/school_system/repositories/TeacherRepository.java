package com.bezy.school_system.repositories;

import com.bezy.school_system.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query(value = "SELECT * FROM teachers WHERE id = :id", nativeQuery = true)
    Optional<Teacher> findTeacherDirectly(@Param("id") Long id);
}
