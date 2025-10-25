package com.bezy.school_system.repositories;

import com.bezy.school_system.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByName(String name);
}