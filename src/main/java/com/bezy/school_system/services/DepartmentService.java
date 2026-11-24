package com.bezy.school_system.services;

import com.bezy.school_system.dtos.DepartmentDto;
import com.bezy.school_system.dtos.RegisterDepartmentRequest;
import com.bezy.school_system.dtos.UpdateDepartmentRequest;
import com.bezy.school_system.entities.Department;
import com.bezy.school_system.entities.Teacher;
import com.bezy.school_system.mappers.AssignmentMapper;
import com.bezy.school_system.mappers.DepartmentMapper;
import com.bezy.school_system.repositories.DepartmentRepository;
import com.bezy.school_system.repositories.TeacherRepository;
import io.jsonwebtoken.impl.security.EdwardsCurve;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;
    private TeacherRepository teacherRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             DepartmentMapper departmentMapper,
                             TeacherRepository teacherRepository) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
        this.teacherRepository = teacherRepository;
    }

    public Department createDepartment(
            @RequestBody RegisterDepartmentRequest request,
            Long teacherId
    ){
        Department department = new Department();
        department.setName(request.getName());
        department.setId(request.getId());
        department.setMembers(request.getMembers());
        departmentRepository.save(department);
        return department;
    }

    public ResponseEntity<?> updateDepartmentById(
            @PathVariable Long id,
            @RequestBody UpdateDepartmentRequest request
    ){
        var department = departmentRepository.findById(id).orElse(null);
        if(department == null){
            return ResponseEntity.notFound().build();
        }

        departmentMapper.update(request, department);
        departmentRepository.save(department);
        return  ResponseEntity.ok().build();
    }

    public Iterable<?> getAllDepartments(
    ){
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toDto)
                .toList();
    }

    public ResponseEntity<?> getDepartmentById(
            @PathVariable Long id
    ){
        var dep =  departmentRepository.findById(id).orElse(null);
        if(dep == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(departmentMapper.toDto(dep));
    }

    public ResponseEntity<?> deleteDepartmentById(
            @PathVariable Long id
    ){
        var department = departmentRepository.findById(id).orElse(null);
        if(department == null){
            return ResponseEntity.notFound().build();
        }

        departmentRepository.delete(department);
        return ResponseEntity.ok().build();
    }
}
