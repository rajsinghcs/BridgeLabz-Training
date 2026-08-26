package com.strike.fundooNotesApp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoteRequest {

    @NotBlank
    private String title;
    private String description;
}