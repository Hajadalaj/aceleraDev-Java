package com.challenge.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImpl implements SubmissionServiceInterface {

 @Autowired
 private SubmissionRepository submissionRepository;
 
 @Override
 public Submission save(Submission object) {
  return this.submissionRepository.save(object);
 }

 @Override
 public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
  return this.submissionRepository.findHigherScoreByChallengeId(challengeId);
 }

 @Override
 public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
  return this.submissionRepository.findByChallegeIdAndAccelerationId(challengeId,accelerationId);
 }
 
}