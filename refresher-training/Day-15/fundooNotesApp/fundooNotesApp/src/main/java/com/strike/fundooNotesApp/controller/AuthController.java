package com.strike.fundooNotesApp.controller;

import com.strike.fundooNotesApp.dto.AuthResponse;
import com.strike.fundooNotesApp.dto.LoginRequest;
import com.strike.fundooNotesApp.dto.RegisterRequest;
import com.strike.fundooNotesApp.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService=authService;
    }
    @PostMapping("/userSignUp")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request){
        AuthResponse res=authService.register(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(res);
    }
    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello Raj");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request){
        AuthResponse resp=authService.login(request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(resp);
    }
}
