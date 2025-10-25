package com.bezy.school_system.mappers;

import com.bezy.school_system.entities.Exam;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamMapper {
    Exam toDto(Exam exam);
}
