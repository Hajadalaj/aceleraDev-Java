package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Candidate;

public interface CandidateServiceInterface extends ServiceInterface<Candidate> {
    
    List<Candidate> findByCompanyId(Long companyId);

    List<Candidate> findByAccelerationId(Long accelerationId);

    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

}
