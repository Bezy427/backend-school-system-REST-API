package com.bezy.school_system.services;

import com.bezy.school_system.dtos.RegisterAssignmentRequest;
import com.bezy.school_system.dtos.UpdateAssignmentRequest;
import com.bezy.school_system.entities.Assignment;
import com.bezy.school_system.entities.Subject;
import com.bezy.school_system.entities.Teacher;
import com.bezy.school_system.mappers.AssignmentMapper;
import com.bezy.school_system.repositories.AssignmentRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AssignmentService {
    private AssignmentRepository assignmentRepository;
    private AssignmentMapper assignmentMapper;

    public Assignment createAssignment(
            @RequestBody RegisterAssignmentRequest request,
            Subject subject,
            Teacher teacher
    ){
        Assignment assignment = new Assignment();
        assignment.setId(request.getId());
        assignment.setTeacher(request.getTeacher());
        assignment.setSubject(subject);
        assignment.setTeacher(teacher);
        assignment.setDueDate(request.getDueDate());
        assignmentRepository.save(assignment);
        return assignment;
    }

    public ResponseEntity<?> updateAssignmentById(
            @RequestBody UpdateAssignmentRequest request
    ){
        var assignment = assignmentRepository.findById(request.getId()).orElse(null);
        if(assignment == null){
            return ResponseEntity.notFound().build();
        }

        assignmentMapper.update(request, assignment);
        assignmentRepository.save(assignment);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteAssignmentById(
            @PathVariable Long id
    ){
        var assignment = assignmentRepository.findById(id).orElse(null);
        if(assignment == null){
            return ResponseEntity.notFound().build();
        }
        assignmentRepository.delete(assignment);
        return ResponseEntity.ok().build();
    }
}
