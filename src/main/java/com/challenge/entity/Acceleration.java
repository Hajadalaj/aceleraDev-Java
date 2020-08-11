package com.challenge.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Acceleration {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

 @NotNull
 @Size(max = 100)
 private String name;

 @NotNull
 @Size(max = 50)
 private String slug;
 
 @ManyToOne
 private Challenge challenge;
 
 @OneToMany
 private List<Candidate> candidate;

 @CreatedDate
 private LocalDate createdAt;
 
}