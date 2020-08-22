package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

    List<Candidate> findByIdCompanyId(Long companyId);
    
    List<Candidate> findByIdAccelerationId(Long accelerationId);

    Optional<Candidate> findByIdUserIdAndIdCompanyIdAndIdAccelerationId(Long userId, Long companyId, Long accelerationId);


}

