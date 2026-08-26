package com.strike.fundooNotesApp.controller;

import com.strike.fundooNotesApp.dto.NoteRequest;
import com.strike.fundooNotesApp.dto.NoteResponse;
import com.strike.fundooNotesApp.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/create")
    public ResponseEntity<NoteResponse> createNote(
            @Valid @RequestBody NoteRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(noteService.createNote(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<NoteResponse>> getAllNotes() {

        return ResponseEntity.ok(
                noteService.getAllNotes()
        );
    }

    @PutMapping("/update/{noteId}")
    public ResponseEntity<NoteResponse> updateNote(
            @PathVariable Long noteId,
            @Valid @RequestBody NoteRequest request) {

        return ResponseEntity.ok(
                noteService.updateNote(noteId, request)
        );
    }

    @DeleteMapping("/delete/{noteId}")
    public ResponseEntity<String> deleteNote(
            @PathVariable Long noteId) {

        noteService.deleteNote(noteId);
        return ResponseEntity.ok("Note Deleted Successfully");
    }

    @PutMapping("/{noteId}/pin")
    public ResponseEntity<NoteResponse> pinNote(@PathVariable Long noteId){
        return ResponseEntity.ok(noteService.pinNote(noteId));
    }

    @PutMapping("/{noteId}/archive")
    public ResponseEntity<NoteResponse> archiveNote(@PathVariable Long noteId){
        return ResponseEntity.ok(noteService.archiveNote(noteId));
    }

    @PutMapping("{noteId}/trash")
    public ResponseEntity<NoteResponse> trashNote(@PathVariable Long noteId){
        return ResponseEntity.ok(noteService.trashNote(noteId));
    }
}