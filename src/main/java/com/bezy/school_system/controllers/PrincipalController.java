package com.bezy.school_system.controllers;

import com.bezy.school_system.dtos.PrincipalDto;
import com.bezy.school_system.dtos.StudentDto;
import com.bezy.school_system.entities.Principal;
import com.bezy.school_system.entities.Student;
import com.bezy.school_system.mappers.PrincipalMapper;
import com.bezy.school_system.repositories.PrincipalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class PrincipalController {
    private final PrincipalRepository principalRepository;
    private final PrincipalMapper principalMapper;

    public PrincipalController(PrincipalRepository principalRepository, PrincipalMapper principalMapper) {
        this.principalRepository = principalRepository;
        this.principalMapper = principalMapper;
    }

    @GetMapping
    public List<Principal> getAllPrincipals(PrincipalDto principalDto) {
        return principalRepository.findAll()
                .stream()
                .map(principalMapper::toDto)
                .toList();
    }
}
