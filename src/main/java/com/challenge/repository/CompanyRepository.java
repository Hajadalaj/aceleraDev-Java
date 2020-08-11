package com.challenge.repository;

import java.util.List;

import com.challenge.entity.Company;

import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company,Long> {

	List<Company> findByCandidatesIdUserId(Long userId);
 
	List<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);

}