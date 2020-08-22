package com.challenge.endpoints;

import java.util.Optional;

import javax.websocket.server.PathParam;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

 @Autowired
 private CandidateService candidateService;

 @Autowired
 private CandidateMapper candidateMapper;

 @GetMapping("/{userId}/{companyId}/{accelerationId}")
 public ResponseEntity<CandidateDTO> findById(@PathVariable("userId") Long userId, 
                                           @PathVariable("companyId") Long companyId, 
                                           @PathVariable("accelerationId") Long accelerationId){
  Optional<Candidate> candidate = this.candidateService.findById(userId, companyId, accelerationId);
  return candidate.isPresent() ? new ResponseEntity<CandidateDTO>(this.candidateMapper.map(candidate.get()),HttpStatus.OK)
  : new ResponseEntity<CandidateDTO>(new CandidateDTO(), HttpStatus.OK);
  
 }

 @GetMapping
 public Iterable<Candidate> findByCompanyId(@PathParam("CompanyId") Long companyId) {
  return this.candidateService.findByCompanyId(companyId);

 }

 @GetMapping("/ByAcceleration")
 public Iterable<Candidate> findByAccelerationId(@PathParam("id") Long accelerationId) {
  return this.candidateService.findByAccelerationId(accelerationId);
 }
 
}