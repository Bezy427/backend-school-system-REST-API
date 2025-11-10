package com.bezy.school_system.services;

import com.bezy.school_system.dtos.RegisterSubjectRequest;
import com.bezy.school_system.dtos.UpdateSubjectRequest;
import com.bezy.school_system.entities.Subject;
import com.bezy.school_system.mappers.SubjectMapper;
import com.bezy.school_system.repositories.SubjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;
    private SubjectMapper subjectMapper;

    public  SubjectService(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    public Subject createSubject(
            @RequestBody RegisterSubjectRequest request
    ){
        Subject subject = new Subject();
        subject.setId(request.getId());
        subject.setSubjectName(request.getSubjectName());
        subject.setDepartment(request.getDepartmentId());
        subjectRepository.save(subject);
        return subject;
    }

    public ResponseEntity<?> updateSubject(
            @PathVariable Long id,
            @RequestBody UpdateSubjectRequest request
    ){
        var subject = subjectRepository.findById(id).orElse(null);
        if(subject == null){
            return ResponseEntity.notFound().build();
        }

        subjectMapper.update(request, subject);
        subjectRepository.save(subject);

        return ResponseEntity.ok(subjectMapper.toDto(subject));
    }

    public ResponseEntity<?> getSubjectById(
            @PathVariable Long id
    ){
        var subject = subjectRepository.findById(id).orElse(null);
        if(subject == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(subjectMapper.toDto(subject));
    }

    public Iterable<?> getAllSubject(
            ){
        return subjectRepository.findAll()
                .stream()
                .map(subjectMapper::toDto)
                .toList();
    }

    public ResponseEntity<?> deleteSubjectById(
            @PathVariable Long id
    ){
        var subject =  subjectRepository.findById(id).orElse(null);
        if(subject == null){
            return ResponseEntity.notFound().build();
        }
        subjectRepository.delete(subject);
        return ResponseEntity.ok().build();
    }
}
