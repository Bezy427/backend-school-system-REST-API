package com.bezy.school_system.controllers;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;

    public JwtResponse(String token){
        this.token = token;
    }

}
