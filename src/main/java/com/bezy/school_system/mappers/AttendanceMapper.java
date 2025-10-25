package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.AttendanceDto;
import com.bezy.school_system.entities.Attendance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {
    AttendanceDto toDto(Attendance attendance);
}
