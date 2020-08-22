package com.challenge.endpoints;

import javax.websocket.server.PathParam;

import com.challenge.entity.Submission;
import com.challenge.service.impl.SubmissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

 @Autowired
 private SubmissionService submissionService;

 @GetMapping
 public Iterable<Submission> findByChallengeIdAndAccelerationId(@PathParam("challengeId") Long challengeId, 
                                                                @PathParam("challengeId") Long accelerationId){
  return this.submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);

 }
 
}