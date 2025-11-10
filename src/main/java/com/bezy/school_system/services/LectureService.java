package com.bezy.school_system.services;

import com.bezy.school_system.dtos.RegisterLectureRequest;
import com.bezy.school_system.dtos.UpdateLectureRequest;
import com.bezy.school_system.entities.Lecture;
import com.bezy.school_system.mappers.AssignmentMapper;
import com.bezy.school_system.mappers.LectureMapper;
import com.bezy.school_system.repositories.LectureRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LectureService {
    private LectureRepository lectureRepository;
    private LectureMapper lectureMapper;

    public LectureService(LectureRepository lectureRepository, LectureMapper lectureMapper) {
        this.lectureRepository = lectureRepository;
        this.lectureMapper = lectureMapper;
    }

    public Lecture createLecture(
            @RequestBody RegisterLectureRequest request
    ){
        Lecture lecture = new Lecture();
        lecture.setId(request.getId());
        lecture.setStartTime(request.getStartTime());
        lecture.setEndTime(request.getEndTime());
        lecture.setLocation(request.getLocation());
        lecture.setTeacher(request.getTeacher());
        lecture.setTeacherName(request.getTeacherName());
        lecture.setSubjectName(request.getSubjectName());
        lectureRepository.save(lecture);
        return lecture;
    }

    public ResponseEntity<?> deleteLectureById(
            @PathVariable Long id
    ){
        var lecture = lectureRepository.findById(id).orElse(null);
        if(lecture == null){
            return ResponseEntity.notFound().build();
        }

        lectureRepository.delete(lecture);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<?> getLectureById(
            @PathVariable Long id
    ){
        var lecture = lectureRepository.findById(id).orElse(null);
        if(lecture == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(lecture);
    }
    public ResponseEntity<?> updateLectureById(
            @PathVariable Long id,
            @RequestBody UpdateLectureRequest request
    ){
        var lecture = lectureRepository.findById(id).orElse(null);
        if(lecture == null){
            return ResponseEntity.notFound().build();
        }

        lectureMapper.update(request, lecture);
        lectureRepository.save(lecture);
        return ResponseEntity.noContent().build();
    }

    public Iterable<?> getAllLecture(
            @PathVariable Long id
    ){
        return lectureRepository.findAll()
                .stream()
                .map(lectureMapper::toDto)
                .toList();
    }
}

