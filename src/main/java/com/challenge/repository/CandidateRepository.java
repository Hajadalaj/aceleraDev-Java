package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate,CandidateId>{

	List<Candidate> findByIdCompanyId(Long companyId);

	List<Candidate> findByIdAccelerationId(Long accelerationId);

	Optional<Candidate> findByIdUserIdAndIdCompanyIdAndIdAccelerationId(Long userId, Long companyId, Long accelerationId);

	 
}