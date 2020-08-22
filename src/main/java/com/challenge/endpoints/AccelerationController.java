package com.challenge.endpoints;

import javax.websocket.server.PathParam;

import com.challenge.entity.Acceleration;
import com.challenge.exceptions.ResourceNotFoundException;
import com.challenge.service.impl.AccelerationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

 @Autowired
 private AccelerationService accelerationService;

 @GetMapping("/{id}")
 public ResponseEntity<Acceleration> findById(@PathVariable("id") Long id) {
  return new ResponseEntity<Acceleration>(this.accelerationService.findById(id)
  .orElseThrow(() -> new ResourceNotFoundException("Aceleração")),HttpStatus.OK);
 }

 @GetMapping
 public Iterable<Acceleration> findByCompanyId(@PathParam("companyId") Long companyId) {
  return this.accelerationService.findByCompanyId(companyId);
 }
 
}