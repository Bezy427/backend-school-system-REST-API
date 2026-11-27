package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.LectureDto;
import com.bezy.school_system.dtos.UpdateLectureRequest;
import com.bezy.school_system.entities.Lecture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LectureMapper {

    @Mapping(source = "teacher.id", target = "teacherId")
    LectureDto toDto(Lecture lecture);

    void update(
            UpdateLectureRequest request,
            @MappingTarget Lecture lecture
    );
}