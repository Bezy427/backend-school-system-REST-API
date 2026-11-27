
package com.bezy.school_system.services;

import com.bezy.school_system.dtos.LectureDto;
import com.bezy.school_system.dtos.RegisterLectureRequest;
import com.bezy.school_system.dtos.UpdateLectureRequest;
import com.bezy.school_system.entities.Lecture;
import com.bezy.school_system.entities.Teacher;
import com.bezy.school_system.mappers.LectureMapper;
import com.bezy.school_system.repositories.LectureRepository;
import com.bezy.school_system.repositories.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {

    private final LectureRepository lectureRepository;
    private final LectureMapper lectureMapper;
    private final TeacherRepository teacherRepository;

    public LectureService(
            LectureRepository lectureRepository,
            LectureMapper lectureMapper,
            TeacherRepository teacherRepository) {
        this.lectureRepository = lectureRepository;
        this.lectureMapper = lectureMapper;
        this.teacherRepository = teacherRepository;
    }

    public Lecture createLecture(RegisterLectureRequest request) {

        Teacher teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() ->
                        new RuntimeException("Teacher not found with ID: " + request.getTeacherId()));

        Lecture lecture = new Lecture();

        lecture.setStartTime(request.getStartTime());
        lecture.setEndTime(request.getEndTime());
        lecture.setSubjectName(request.getSubjectName());
        lecture.setLocation(request.getLocation());
        lecture.setTeacher(teacher);
        lecture.setTeacherName(
                teacher.getFirstName() + " " + teacher.getLastName()
        );

        return lectureRepository.save(lecture);
    }

    public ResponseEntity<?> deleteLectureById(Long id) {
        var lecture = lectureRepository.findById(id).orElse(null);

        if (lecture == null) {
            return ResponseEntity.notFound().build();
        }

        lectureRepository.delete(lecture);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<?> getLectureById(Long id) {
        var lecture = lectureRepository.findById(id).orElse(null);

        if (lecture == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(lecture);
    }

    public ResponseEntity<?> updateLectureById(
            Long id,
            UpdateLectureRequest request) {

        var lecture = lectureRepository.findById(id).orElse(null);

        if (lecture == null) {
            return ResponseEntity.notFound().build();
        }

        lectureMapper.update(request, lecture);
        lectureRepository.save(lecture);

        return ResponseEntity.noContent().build();
    }

    public List<LectureDto> getAllLecture() {
        return lectureRepository.findAll()
                .stream()
                .map(lectureMapper::toDto)
                .toList();
    }
}
