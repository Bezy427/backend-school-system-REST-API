package com.bezy.school_system.mappers;

import com.bezy.school_system.dtos.EventDto;
import com.bezy.school_system.dtos.RegisterEventRequest;
import com.bezy.school_system.dtos.UpdateEventRequest;
import com.bezy.school_system.entities.Event;
import org.hibernate.sql.Update;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDto toDto(Event event);
    void update(UpdateEventRequest request, @MappingTarget Event event);

}
