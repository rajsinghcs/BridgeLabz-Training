package com.strike.fundooNotesApp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LabelRequest {
    @NotBlank
    private String labelName;

}
