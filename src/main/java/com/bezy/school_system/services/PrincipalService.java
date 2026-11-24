package com.bezy.school_system.services;

import com.bezy.school_system.dtos.PrincipalDto;
import com.bezy.school_system.dtos.RegisterPrincipalRequest;
import com.bezy.school_system.dtos.UpdatePrincipalRequest;
import com.bezy.school_system.entities.Principal;
import com.bezy.school_system.entities.Role;
import com.bezy.school_system.entities.User;
import com.bezy.school_system.mappers.PrincipalMapper;
import com.bezy.school_system.repositories.PrincipalRepository;
import com.bezy.school_system.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PrincipalService {
    private final PrincipalRepository principalRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private PrincipalMapper principalMapper;

    public PrincipalService(PrincipalRepository principalRepository,
                            UserRepository userRepository,
                            PasswordEncoder passwordEncoder,
                            PrincipalMapper principalMapper) {
        this.principalRepository = principalRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.principalMapper = principalMapper;
    }

    public Principal createPrincipal(RegisterPrincipalRequest request
    ){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRole(Role.PRINCIPAL);

        Principal principal = new Principal();
        principal.setOfficeLocation(request.getOfficeLocation());
        principal.setStartDate(request.getStartDate());
        principal.setUsername(request.getUsername());
        principal.setPassword(request.getPassword());
        principal.setEmail(request.getEmail());
        principal.setRole(Role.PRINCIPAL);
        principal.setUser(user);
        user.setPrincipal(principal);
        userRepository.save(user);
        return principal;
    }

    public ResponseEntity<?> updatePrincipal(
            @RequestBody UpdatePrincipalRequest request,
            @PathVariable Long id
    ){
        var principal = principalRepository.findById(id).orElse(null);
        if(principal == null){
            return ResponseEntity.notFound().build();
        }

        principalMapper.update(request, principal);
        principalRepository.save(principal);
        return ResponseEntity.ok().build();
    }

    public Iterable<?> getPrincipal() {
        return principalRepository.findAll()
                .stream()
                .map(principal -> principalMapper.toDto(principal))
                .toList();
    }
}
