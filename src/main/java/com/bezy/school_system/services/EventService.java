package com.bezy.school_system.services;

import com.bezy.school_system.dtos.EventDto;
import com.bezy.school_system.dtos.RegisterEventRequest;
import com.bezy.school_system.dtos.UpdateEventRequest;
import com.bezy.school_system.entities.Event;
import com.bezy.school_system.mappers.AssignmentMapper;
import com.bezy.school_system.mappers.EventMapper;
import com.bezy.school_system.repositories.EventRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EventService {
    private EventRepository eventRepository;
    private EventMapper eventMapper;

    public EventService(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public Event createEvent(
            @RequestBody RegisterEventRequest request
    ){
        Event event = new Event();
        event.setComments(request.getComments());
        event.setTitle(request.getTitle());
        event.setDate(request.getDate());
        event.setEndTime(request.getEndTime());
        event.setStartTime(request.getStartTime());
        event.setId(request.getId());
        eventRepository.save(event);
        return event;
    }

    public ResponseEntity<?> updateEvent(
            @PathVariable Long id,
            @RequestBody UpdateEventRequest request
    ){
        var event = eventRepository.findById(id).orElse(null);
        if(event == null){
            return ResponseEntity.notFound().build();
        }

        eventMapper.update(request, event);
        eventRepository.save(event);
        return ResponseEntity.ok().build();
    }

    public Iterable<?> getAllEvents(){
        return eventRepository.findAll()
                .stream()
                .map(event -> eventMapper.toDto(event))
                .toList();
    }

    public ResponseEntity<?> getEventById(
            @PathVariable Long id
    ) {
        var event = eventRepository.findById(id).orElse(null);
        if(event == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(eventMapper.toDto(event));
    }

    public ResponseEntity<?> deleteEventById(
            @PathVariable Long id
    ){
        var event = eventRepository.findById(id).orElse(null);
        if(event == null){
            return ResponseEntity.notFound().build();
        }

        eventRepository.delete(event);
        return ResponseEntity.ok().build();
    }
}
