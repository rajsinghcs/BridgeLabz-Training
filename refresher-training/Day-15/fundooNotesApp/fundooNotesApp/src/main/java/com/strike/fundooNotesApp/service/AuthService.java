package com.strike.fundooNotesApp.service;

import com.strike.fundooNotesApp.dto.AuthResponse;
import com.strike.fundooNotesApp.dto.LoginRequest;
import com.strike.fundooNotesApp.dto.RegisterRequest;
import com.strike.fundooNotesApp.entity.User;
import com.strike.fundooNotesApp.exception.DuplicateEmailException;
import com.strike.fundooNotesApp.repository.UserRepository;
import com.strike.fundooNotesApp.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.jwtUtil=jwtUtil;
    }

    public AuthResponse register(RegisterRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new DuplicateEmailException("Email Already Registered");
        }
        User user=new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword())
        );

        userRepository.save(user);

        String token=jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);

    }
    public AuthResponse login(LoginRequest request){
        User user=userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new RuntimeException("Invalid Email or Password"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())){
            throw  new RuntimeException("Invalid Email or Password");
        }
        String token=jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token);

    }
}
