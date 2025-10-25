package com.bezy.school_system.repositories;

import com.bezy.school_system.entities.Principal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrincipalRepository extends JpaRepository<Principal, Long> {
}