package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class CandidateIdentity {
 
 @NotNull
 @ManyToOne
 private User user;
 
 @NotNull
 @ManyToOne
 private Acceleration acceleration;

 @NotNull
 @ManyToOne
 private Company company;

}