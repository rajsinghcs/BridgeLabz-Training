package com.contactApp.contactApp.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Table(name="ContactApp")
public class ContactApp{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name",nullable=false)
    private String name;
    @Column(name ="mail", unique=true, nullable=false)
    private String mail;
    @Column(name="mobNo",unique=true,nullable=false)
    private String mobNo;
}
