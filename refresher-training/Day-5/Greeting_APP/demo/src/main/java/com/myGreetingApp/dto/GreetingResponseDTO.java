package com.myGreetingApp.dto;

public class GreetingResponseDTO {
    private String message;

    public GreetingResponseDTO() {}

    public GreetingResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GreetingResponseDTO{message='" + message + "'}";
    }
}
