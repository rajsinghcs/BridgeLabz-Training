package com.strike.fundooNotesApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "labels")
@Data
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labelId;

    @Column(nullable = false)
    private String labelName;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}