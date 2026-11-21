package com.bezy.school_system.repositories;

import com.bezy.school_system.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
