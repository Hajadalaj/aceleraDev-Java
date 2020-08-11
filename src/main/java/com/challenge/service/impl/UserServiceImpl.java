package com.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserServiceInterface {

 @Autowired
 private UserRepository userRepository;
 
 @Override
 @Transactional
 public User save(User user) {
  return this.userRepository.save(user);
 }

 @Override
 public Optional<User> findById(Long userId) {
  return this.userRepository.findById(userId);
 }

 @Override
 public List<User> findByAccelerationName(String name) {
  return this.userRepository.findByCandidatesIdAccelerationName(name);
 }

 @Override
 public List<User> findByCompanyId(Long companyId) {
  return this.userRepository.findByCandidatesIdCompanyId(companyId);
 }

}