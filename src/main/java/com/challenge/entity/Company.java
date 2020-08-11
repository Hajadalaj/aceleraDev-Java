package com.challenge.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Company {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

 @NotNull
 @Size(max = 100)
 private String name;
 
 @NotNull
 @Size(max = 50)
 private String slug;

 @CreatedDate
 private LocalDate createdAt;

 @OneToMany
 private List<Candidate> candidates;

}