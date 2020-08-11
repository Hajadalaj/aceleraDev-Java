package com.challenge.entity;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Submission {

 @EmbeddedId
 private SubmissionIdentity submissionIdentity;

 @NotNull
 private double score;

 @CreatedDate
 private LocalDate createdAt;
  
}