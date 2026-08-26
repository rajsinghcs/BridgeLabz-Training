package com.strike.fundooNotesApp.repository;

import com.strike.fundooNotesApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email); // for fetching user while login
    boolean existsByEmail(String email);        // check during registration email already exist or not
}