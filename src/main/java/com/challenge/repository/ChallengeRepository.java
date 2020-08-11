package com.challenge.repository;

import java.util.List;

import com.challenge.entity.Challenge;

import org.springframework.data.repository.CrudRepository;

public interface ChallengeRepository extends CrudRepository<Challenge,Long> {

	List<Challenge> findByAccelerationsIdAndSubmissionsIdUserId(Long accelerationId, Long userId);
 
}