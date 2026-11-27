
package com.bezy.school_system.controllers;

import com.bezy.school_system.dtos.PrincipalDto;
import com.bezy.school_system.dtos.RegisterLectureRequest;
import com.bezy.school_system.dtos.UpdateLectureRequest;
import com.bezy.school_system.entities.Lecture;
import com.bezy.school_system.entities.Principal;
import com.bezy.school_system.repositories.TeacherRepository;
import com.bezy.school_system.services.LectureService;
import com.bezy.school_system.repositories.PrincipalRepository;
import com.bezy.school_system.mappers.PrincipalMapper;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/principal")
public class PrincipalController {

    private final PrincipalRepository principalRepository;
    private final PrincipalMapper principalMapper;
    private final LectureService lectureService;
    private TeacherRepository teacherRepository;

    public PrincipalController(
            PrincipalRepository principalRepository,
            PrincipalMapper principalMapper,
            LectureService lectureService) {

        this.principalRepository = principalRepository;
        this.principalMapper = principalMapper;
        this.lectureService = lectureService;
    }

    @GetMapping
    public List<Principal> getAllPrincipals() {
        return principalRepository.findAll()
                .stream()
                .toList();
    }

    // CREATE LECTURE
    @PostMapping("/lectures")
    public ResponseEntity<Lecture> createLecture(
            @Valid @RequestBody RegisterLectureRequest request) {

        Lecture lecture = lectureService.createLecture(request);
        return ResponseEntity.ok(lecture);
    }

    // GET ALL LECTURES
    @GetMapping("/lectures")
    public ResponseEntity<?> getAllLectures() {
        return ResponseEntity.ok(lectureService.getAllLecture());
    }

    // GET LECTURE BY ID
    @GetMapping("/lectures/{id}")
    public ResponseEntity<?> getLectureById(@PathVariable Long id) {
        return lectureService.getLectureById(id);
    }

    // UPDATE LECTURE
    @PutMapping("/lectures/{id}")
    public ResponseEntity<?> updateLecture(
            @PathVariable Long id,
            @RequestBody UpdateLectureRequest request) {

        return lectureService.updateLectureById(id, request);
    }

    // DELETE LECTURE
    @DeleteMapping("/lectures/{id}")
    public ResponseEntity<?> deleteLecture(@PathVariable Long id) {
        return lectureService.deleteLectureById(id);
    }
}
