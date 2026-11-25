
package com.bezy.school_system.services;

import com.bezy.school_system.dtos.DepartmentDto;
import com.bezy.school_system.dtos.RegisterDepartmentRequest;
import com.bezy.school_system.dtos.UpdateDepartmentRequest;
import com.bezy.school_system.entities.Department;
import com.bezy.school_system.mappers.DepartmentMapper;
import com.bezy.school_system.repositories.DepartmentRepository;
import com.bezy.school_system.repositories.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final TeacherRepository teacherRepository;

    public DepartmentService(
            DepartmentRepository departmentRepository,
            DepartmentMapper departmentMapper,
            TeacherRepository teacherRepository
    ) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
        this.teacherRepository = teacherRepository;
    }

    public Department createDepartment(
            RegisterDepartmentRequest request
    ) {
        Department department = new Department();

        department.setName(request.getName());
        department.setId(request.getId());
        department.setMembers(request.getMembers());

        departmentRepository.save(department);

        return department;
    }

    public ResponseEntity<?> updateDepartmentById(
            Long id,
            UpdateDepartmentRequest request
    ) {
        var department = departmentRepository.findById(id).orElse(null);

        if (department == null) {
            return ResponseEntity.notFound().build();
        }

        departmentMapper.update(request, department);
        departmentRepository.save(department);

        return ResponseEntity.ok().build();
    }

    public Iterable<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toDto)
                .toList();
    }

    public ResponseEntity<?> getDepartmentById(Long id) {
        var department = departmentRepository.findById(id).orElse(null);

        if (department == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(departmentMapper.toDto(department));
    }

    public ResponseEntity<?> deleteDepartmentById(Long id) {
        var department = departmentRepository.findById(id).orElse(null);

        if (department == null) {
            return ResponseEntity.notFound().build();
        }

        departmentRepository.delete(department);

        return ResponseEntity.ok().build();
    }
}
