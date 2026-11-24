package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.SchoolFeeDto;
import com.bezy.school_system.dtos.UpdateSchoolFeeRequest;
import com.bezy.school_system.entities.SchoolFee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SchoolFeeMapper {
    SchoolFeeDto toDto(SchoolFee schoolFee);
    void update(UpdateSchoolFeeRequest request, @MappingTarget SchoolFee schoolFee);
}
