package com.bezy.school_system.repositories;

import com.bezy.school_system.dtos.UpdateAssignmentRequest;
import com.bezy.school_system.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}