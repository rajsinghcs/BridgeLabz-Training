package com.strike.fundooNotesApp.repository;

import com.strike.fundooNotesApp.entity.Note;
import com.strike.fundooNotesApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUser(User user);
    Optional<Note> findByNoteIdAndUser(Long noteId, User user);
    List<Note> findByUserAndPinnedTrue(User  user);
    List<Note> findByUserAndArchivedTrue(User user);
    List<Note>findByUserAndTrashedTrue(User user);
    List<Note> findByUserAndArchivedFalseAndTrashedFalse(User user);
    List<Note> findByUserAndLabels_LabelId(
            User user,
            Long labelId
    );
}