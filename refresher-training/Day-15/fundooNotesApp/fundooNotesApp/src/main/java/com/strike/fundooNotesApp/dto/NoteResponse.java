package com.strike.fundooNotesApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class NoteResponse {

    private Long noteId;
    private String title;
    private String description;
    private boolean pinned;
    private boolean archived;
    private boolean trashed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}