package com.bezy.school_system.repositories;

import com.bezy.school_system.dtos.LectureDto;
import com.bezy.school_system.entities.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
  //List<?> findLectureById(Long id);
}