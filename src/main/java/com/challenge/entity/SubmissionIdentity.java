package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class SubmissionIdentity {
 
 @NotNull
 @ManyToOne
 private User user;
 
 @NotNull
 @ManyToOne
 private Challenge challenge;

}