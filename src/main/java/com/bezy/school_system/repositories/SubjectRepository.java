package com.bezy.school_system.repositories;

import com.bezy.school_system.dtos.UpdateSubjectRequest;
import com.bezy.school_system.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}