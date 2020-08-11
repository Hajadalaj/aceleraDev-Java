package com.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyServiceInterface {

 @Autowired
 private CompanyRepository companyRepository;
 
 @Override
 public Company save(Company object) {
  return this.companyRepository.save(object);
 }

 @Override
 public Optional<Company> findById(Long id) {
  return this.companyRepository.findById(id);
 }

 @Override
 public List<Company> findByAccelerationId(Long accelerationId) {
  return this.companyRepository.findDistinctByCandidatesIdAccelerationId(accelerationId);
 }

 @Override
 public List<Company> findByUserId(Long userId) {
  return this.companyRepository.findByCandidatesIdUserId(userId);
 }
 
}