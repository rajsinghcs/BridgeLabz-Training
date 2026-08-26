package com.strike.fundooNotesApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class LabelResponse {

    private Long labelId;
    private String labelName;
}