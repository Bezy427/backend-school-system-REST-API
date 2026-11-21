package com.bezy.school_system.repositories;

import com.bezy.school_system.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}