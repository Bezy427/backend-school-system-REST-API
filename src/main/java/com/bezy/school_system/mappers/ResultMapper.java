package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.RegisterResultRequest;
import com.bezy.school_system.dtos.ResultDto;
import com.bezy.school_system.dtos.UpdateResultRequest;
import com.bezy.school_system.entities.Result;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ResultMapper {
    ResultDto toDto(Result result);
    void update(UpdateResultRequest request, @MappingTarget Result result);
}
