package com.myGreetingApp.service;

import com.myGreetingApp.dto.GreetingRequestDTO;
import com.myGreetingApp.dto.GreetingResponseDTO;

public class GreetingService {

    public GreetingResponseDTO greet(GreetingRequestDTO request) {
        String name = "Guest";
        if (request != null && request.getUsername() != null && !request.getUsername().isBlank()) {
            name = request.getUsername();
        }
        String message = "Hello " + name;
        return new GreetingResponseDTO(message);
    }
}
