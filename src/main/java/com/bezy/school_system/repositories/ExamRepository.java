package com.bezy.school_system.repositories;

import com.bezy.school_system.entities.Exam;
import com.bezy.school_system.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByStartTime(LocalTime startTime);
    List<Exam> findByEndTime(LocalTime endTime);
    List<Exam> findByExamDate(LocalDate date);

    List<Exam> findExamBySubjectName(String subjectName);
    // List<Exam> findBySubjectId(Long subjectId);

}