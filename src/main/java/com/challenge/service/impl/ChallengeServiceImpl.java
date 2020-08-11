package com.challenge.service.impl;

import java.util.List;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeServiceInterface {

 @Autowired
 private ChallengeRepository challengeRepository;
 
 @Override
 public Challenge save(Challenge object) {
  return this.challengeRepository.save(object);
 }

 @Override
 public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
  return this.challengeRepository.findByAccelerationsIdAndSubmissionsIdUserId(accelerationId, userId);
 }
 
}