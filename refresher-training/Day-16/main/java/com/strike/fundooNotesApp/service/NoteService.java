package com.strike.fundooNotesApp.service;

import com.strike.fundooNotesApp.dto.LabelResponse;
import com.strike.fundooNotesApp.dto.NoteRequest;
import com.strike.fundooNotesApp.dto.NoteResponse;
import com.strike.fundooNotesApp.entity.Label;
import com.strike.fundooNotesApp.entity.Note;
import com.strike.fundooNotesApp.entity.User;
import com.strike.fundooNotesApp.exception.ResourceNotFoundException;
import com.strike.fundooNotesApp.repository.LabelRepository;
import com.strike.fundooNotesApp.repository.NoteRepository;
import com.strike.fundooNotesApp.repository.UserRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final LabelRepository labelRepository;

    public NoteService(NoteRepository noteRepository,
                       UserRepository userRepository,
                       LabelRepository labelRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.labelRepository=labelRepository;
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

    @CacheEvict(
            value = "notes",
            key = "T(org.springframework.security.core.context.SecurityContextHolder).getContext().getAuthentication().getName()"
    )
    public NoteResponse createNote(NoteRequest request) {

        User user = getLoggedInUser();

        Note note = new Note();

        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        note.setUser(user);

        Note savedNote = noteRepository.save(note);

        return mapToResponse(savedNote);
    }

    @Cacheable(
            value = "notes",
            key = "T(org.springframework.security.core.context.SecurityContextHolder)" +
                    ".getContext().getAuthentication().getName()")
    public List<NoteResponse> getAllNotes() {

        User user = getLoggedInUser();

        return noteRepository
                .findByUserAndArchivedFalseAndTrashedFalse(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @CacheEvict(
            value = "notes",
            key = "T(org.springframework.security.core.context.SecurityContextHolder).getContext().getAuthentication().getName()"
    )
    public NoteResponse updateNote(
            Long noteId,
            NoteRequest request) {

        User user = getLoggedInUser();

        Note note = noteRepository
                .findByNoteIdAndUser(noteId, user)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Note not found"));

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

    public List<NoteResponse> getPinnedNotes(){
        User user=getLoggedInUser();

        List<Note>ll=noteRepository.findByUserAndPinnedTrue(user);
        return ll.stream()
                .map(this::mapToResponse)
                .toList();
    }
    public List<NoteResponse> getArchivedNotes() {

        User user = getLoggedInUser();
        return noteRepository
                .findByUserAndArchivedTrue(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    public List<NoteResponse> getTrashedNotes() {

        User user = getLoggedInUser();

        return noteRepository
                .findByUserAndTrashedTrue(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    //Restore from Trash
    public NoteResponse restoreNote(Long noteId) {

        User user = getLoggedInUser();
        Note note = noteRepository
                .findByNoteIdAndUser(noteId, user)
                .orElseThrow(() ->
                        new RuntimeException("Note not found"));

        note.setTrashed(false);

        return mapToResponse(noteRepository.save(note));
    }

    public NoteResponse addLabelToNote(Long noteId,Long labelId){
        User user=getLoggedInUser();

        Note note=noteRepository
                .findByNoteIdAndUser(noteId,user)
                .orElseThrow(()->
                        new ResourceNotFoundException("Note not Found"));

        Label label=labelRepository.findByLabelIdAndUser(labelId,user)
                .orElseThrow(()-> new ResourceNotFoundException("Label not Found"));

        note.getLabels().add(label);
        return mapToResponse(noteRepository.save(note));
    }

    public NoteResponse removeLabelFromNote(
            Long noteId,
            Long labelId) {

        User user = getLoggedInUser();

        Note note = noteRepository
                .findByNoteIdAndUser(noteId, user)
                .orElseThrow(() ->
                        new RuntimeException("Note not found"));

        Label label = labelRepository
                .findByLabelIdAndUser(labelId, user)
                .orElseThrow(() ->
                        new RuntimeException("Label not found"));

        note.getLabels().remove(label);

        return mapToResponse(noteRepository.save(note));
    }

    public List<NoteResponse> getNotesByLabel(Long labelId) {

        User user = getLoggedInUser();
        labelRepository
                .findByLabelIdAndUser(labelId, user)
                .orElseThrow(() ->
                        new RuntimeException("Label not found"));

        return noteRepository
                .findByUserAndLabels_LabelId(user, labelId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private NoteResponse mapToResponse(Note note) {
        Set<LabelResponse> labels = note.getLabels()
            .stream()
            .map(label -> new LabelResponse(
                    label.getLabelId(),
                    label.getLabelName()
            ))
            .collect(Collectors.toSet());


        return new NoteResponse(
                note.getNoteId(),
                note.getTitle(),
                note.getDescription(),
                note.isPinned(),
                note.isArchived(),
                note.isTrashed(),
                note.getCreatedAt(),
                note.getUpdatedAt(),
                labels
        );
    }
}