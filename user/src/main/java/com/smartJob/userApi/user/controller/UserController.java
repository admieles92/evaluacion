package com.smartJob.userApi.user.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartJob.userApi.user.dto.UserRequest;
import com.smartJob.userApi.user.dto.UserResponse;
import com.smartJob.userApi.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService usuarioService;

    
    @Operation(summary = "Registrar usuario")
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRequest request) {
        try {
            UserResponse response = usuarioService.create(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(Collections.singletonMap("mensaje", ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
