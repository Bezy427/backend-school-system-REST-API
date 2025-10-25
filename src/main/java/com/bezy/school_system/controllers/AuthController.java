package com.bezy.school_system.controllers;

import com.bezy.school_system.config.JwtConfig;
import com.bezy.school_system.dtos.JwtResponse;
import com.bezy.school_system.dtos.LoginRequest;
import com.bezy.school_system.dtos.UserDto;
import com.bezy.school_system.mappers.UserMapper;
import com.bezy.school_system.repositories.UserRepository;
import com.bezy.school_system.services.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final JwtConfig jwtConfig;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtService jwtService,
                          UserRepository userRepository,
                          UserMapper userMapper,
                          JwtConfig jwtConfig) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.jwtConfig = new JwtConfig();
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
            @Valid @RequestBody LoginRequest request,
            HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var accessToken = jwtService.generateAccessToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        var cookie = new Cookie("refreshToken", refreshToken);
        cookie.setHttpOnly(true);
        cookie.setPath("/auth/refresh");
        cookie.setMaxAge(jwtConfig.getRefreshTokenExpiration()); // seven days
        cookie.setSecure(true);
        response.addCookie(cookie);

        return ResponseEntity.ok(new JwtResponse(accessToken));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refresh(
            @CookieValue(value = "refreshToken") String refreshToken
    ){
        if (!jwtService.validateToken(refreshToken)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        var userId = jwtService.getUserIdFromToken(refreshToken);
        var user = userRepository.findById(userId).orElseThrow();
        var accessToken = jwtService.generateAccessToken(user);

        return ResponseEntity.ok(new JwtResponse(accessToken));

    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> me(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var userId = (Long) authentication.getPrincipal();

        var user = userRepository.findById(userId).orElse(null);
        if(user == null){
            return ResponseEntity.notFound().build();
        }

        var userDto = userMapper.toDto(user);

        return ResponseEntity.ok(userDto);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Void> handleBadCredentials() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
