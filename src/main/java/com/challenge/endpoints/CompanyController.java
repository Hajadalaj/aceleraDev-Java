package com.challenge.endpoints;

import javax.websocket.server.PathParam;

import com.challenge.entity.Company;
import com.challenge.exceptions.ResourceNotFoundException;
import com.challenge.service.impl.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

 @Autowired
 private CompanyService companyService;

 @GetMapping("/{id}")
 public ResponseEntity<Company> findById(@PathVariable("id") Long id) {
  return new ResponseEntity<Company>(this.companyService.findById(id)
  .orElseThrow(() -> new ResourceNotFoundException("Cia Não Existe")), HttpStatus.OK);
 }

 @GetMapping
 public Iterable<Company> findAll(@PathParam("accelerationId") Long accelerationId,
                                  @PathParam("userId") Long userId ) {
  if (accelerationId != null) {
   return this.companyService.findByAccelerationId(accelerationId);
  } else if (userId != null) { 
   return this.companyService.findByUserId(userId);
  }
  return null;
 }

}