package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId>{

	@Query("SELECT coalesce(MAX(submission.score),0) FROM Submission as submission WHERE submission.id.challenge.id= :challengeId")
	BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);
	
	@Query("select submission from Submission submission join Acceleration acceleration "
	+ "on submission.id.challenge.id = acceleration.challenge.id "
	+ "where submission.id.challenge.id = :challengeId and acceleration.id = :accelerationId ")
	List<Submission> findByChallegeIdAndAccelerationId(@Param("challengeId") Long challengeId,
																																																				@Param("accelerationId") Long accelerationId);
 
}