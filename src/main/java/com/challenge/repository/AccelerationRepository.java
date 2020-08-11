package com.challenge.repository;

import java.util.List;

import com.challenge.entity.Acceleration;

import org.springframework.data.repository.CrudRepository;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

	List<Acceleration> findByCandidatesIdCompanyId(Long companyId);
 
}