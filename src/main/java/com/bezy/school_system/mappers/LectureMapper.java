package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.LectureDto;
import com.bezy.school_system.dtos.UpdateLectureRequest;
import com.bezy.school_system.entities.Lecture;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface LectureMapper {
    LectureDto toDto(Lecture lecture);
    void update(UpdateLectureRequest request, @MappingTarget Lecture lecture);
}
