package com.bezy.school_system.repositories;

import com.bezy.school_system.entities.Enrollment;
import com.bezy.school_system.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
