package com.challenge.endpoints;

import javax.websocket.server.PathParam;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {
 
 @Autowired
 private ChallengeService challengeService;

 @GetMapping
 public Iterable<Challenge> findByAccelerationIdAndUserId(@PathParam("accelerationId") Long accelerationId, 
                                                          @PathParam("userId") Long userId){
  return this.challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
 }
}