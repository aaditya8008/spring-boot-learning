package com.example.springpracticaldemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import com.example.springpracticaldemo.dto.UserRegisterRequestDto;
import com.example.springpracticaldemo.dto.UserRegisterResponseDto;
import com.example.springpracticaldemo.service.AuthService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(
            @RequestBody UserRegisterRequestDto registerRequestDto) {
        UserRegisterResponseDto userRegisterResponseDto
                = authService.register(registerRequestDto);

        return ResponseEntity.ok(userRegisterResponseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(
            @RequestBody UserRegisterRequestDto registerRequestDto) {
        Boolean loggedIn = authService.login(registerRequestDto);

        return ResponseEntity.ok(loggedIn);
    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken) {
        return csrfToken;
    }

}
