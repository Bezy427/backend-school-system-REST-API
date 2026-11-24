package com.bezy.school_system.repositories;

import com.bezy.school_system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}