package com.ra.project_module5_reactjs.controller.admin;

import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.LoginRequest;
import com.ra.project_module5_reactjs.model.dto.request.RegisterRequest;
import com.ra.project_module5_reactjs.service.design.admin.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> handleRegister(@Valid @RequestBody RegisterRequest registerRequest) throws CustomException {
        userService.register(registerRequest);
        return ResponseEntity.created(URI.create("api/v1/auth/register")).body("Register successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> handleLogin(@Valid @RequestBody LoginRequest loginRequest) throws CustomException {
        return ResponseEntity.ok().body(userService.login(loginRequest));
    }



}
