package com.strike.fundooNotesApp.repository;

import com.strike.fundooNotesApp.entity.Label;
import com.strike.fundooNotesApp.entity.Note;
import com.strike.fundooNotesApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LabelRepository extends JpaRepository<Label, Long> {

    List<Label> findByUser(User user);

    Optional<Label> findByLabelIdAndUser(Long labelId, User user);

    Optional<Label> findByLabelNameAndUser(
            String labelName,
            User user
    );
}