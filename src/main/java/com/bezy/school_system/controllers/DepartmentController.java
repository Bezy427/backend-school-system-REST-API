
package com.bezy.school_system.controllers;

import com.bezy.school_system.dtos.DepartmentDto;
import com.bezy.school_system.dtos.RegisterDepartmentRequest;
import com.bezy.school_system.dtos.UpdateDepartmentRequest;
import com.bezy.school_system.entities.Department;
import com.bezy.school_system.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(
            @RequestBody RegisterDepartmentRequest request
    ) {
        Department department = departmentService.createDepartment(request);

        return ResponseEntity.status(201).body(department);
    }

    @GetMapping
    public Iterable<DepartmentDto> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartment(
            @PathVariable Long id
    ) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(
            @PathVariable Long id,
            @RequestBody UpdateDepartmentRequest request
    ) {
        return departmentService.updateDepartmentById(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(
            @PathVariable Long id
    ) {
        return departmentService.deleteDepartmentById(id);
    }
}
