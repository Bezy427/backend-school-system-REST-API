package com.bezy.school_system.controllers;

import com.bezy.school_system.dtos.DepartmentDto;
import com.bezy.school_system.mappers.DepartmentMapper;
import com.bezy.school_system.repositories.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentController(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @GetMapping
    public Iterable<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartment(
            @PathVariable Long id
    ) {
        departmentRepository.findById(id);
        return ResponseEntity.ok().build();
    }

}
