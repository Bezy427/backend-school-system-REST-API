package com.bezy.school_system.repositories;

import com.bezy.school_system.dtos.UpdateResultRequest;
import com.bezy.school_system.entities.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Long> {
}