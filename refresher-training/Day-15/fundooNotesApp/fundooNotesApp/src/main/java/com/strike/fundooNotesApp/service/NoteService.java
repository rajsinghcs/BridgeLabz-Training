package com.strike.fundooNotesApp.service;

import com.strike.fundooNotesApp.dto.NoteRequest;
import com.strike.fundooNotesApp.dto.NoteResponse;
import com.strike.fundooNotesApp.entity.Note;
import com.strike.fundooNotesApp.entity.User;
import com.strike.fundooNotesApp.repository.NoteRepository;
import com.strike.fundooNotesApp.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository,
                       UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    private User getLoggedInUser() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    public NoteResponse createNote(NoteRequest request) {

        User user = getLoggedInUser();

        Note note = new Note();

        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        note.setUser(user);

        Note savedNote = noteRepository.save(note);

        return mapToResponse(savedNote);
    }

    public List<NoteResponse> getAllNotes() {

        User user = getLoggedInUser();

        return noteRepository.findByUser(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public NoteResponse updateNote(
            Long noteId,
            NoteRequest request) {

        User user = getLoggedInUser();

        Note note = noteRepository
                .findByNoteIdAndUser(noteId, user)
                .orElseThrow(() ->
                        new RuntimeException("Note not found"));

        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());

        return mapToResponse(noteRepository.save(note));
    }

    public void deleteNote(Long noteId) {

        User user = getLoggedInUser();
        Note note = noteRepository
                .findByNoteIdAndUser(noteId, user)
                .orElseThrow(() ->
                        new RuntimeException("Note not found"));

        noteRepository.delete(note);
    }

    public NoteResponse pinNote(Long noteId){
        User user=getLoggedInUser();

        Note note=noteRepository.findByNoteIdAndUser(noteId,user)
                .orElseThrow(()-> new RuntimeException("Note not Found"));

        note.setPinned(!note.isPinned());

        return mapToResponse(noteRepository.save(note));
    }
    public NoteResponse archiveNote(Long noteId){
        User user=getLoggedInUser();

        Note  note=noteRepository.findByNoteIdAndUser(noteId,user)
                .orElseThrow(()->new RuntimeException("Note not Found"));

        note.setArchived(!note.isArchived());
        return mapToResponse(noteRepository.save(note));
    }

    public NoteResponse trashNote(Long noteId) {

        User user = getLoggedInUser();

        Note note = noteRepository
                .findByNoteIdAndUser(noteId, user)
                .orElseThrow(() ->
                        new RuntimeException("Note not found"));

        note.setTrashed(!note.isTrashed());

        return mapToResponse(noteRepository.save(note));
    }

    private NoteResponse mapToResponse(Note note) {

        return new NoteResponse(
                note.getNoteId(),
                note.getTitle(),
                note.getDescription(),
                note.isPinned(),
                note.isArchived(),
                note.isTrashed(),
                note.getCreatedAt(),
                note.getUpdatedAt()
        );
    }
}