package com.myGreetingApp.dto;

public class GreetingRequestDTO {
    private String username;

    public GreetingRequestDTO() {}

    public GreetingRequestDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "GreetingRequestDTO{username='" + username + "'}";
    }
}
