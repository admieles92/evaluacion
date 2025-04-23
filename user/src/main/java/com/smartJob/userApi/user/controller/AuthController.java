package com.smartJob.userApi.user.controller;

import com.smartJob.userApi.user.auth.AuthRequest;
import com.smartJob.userApi.user.auth.AuthResponse;
import com.smartJob.userApi.user.auth.JwtUtil;
import com.smartJob.userApi.user.config.PassProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PassProperties passProperties;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        if (passProperties.getUsername().equals(authRequest.getUsername()) &&
                passProperties.getPassword().equals(authRequest.getPassword())) {
            String token = jwtUtil.generateToken(authRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
