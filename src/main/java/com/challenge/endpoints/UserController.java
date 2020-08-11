package com.challenge.endpoints;

import javax.websocket.server.PathParam;

import com.challenge.entity.User;
import com.challenge.exceptions.ResourceNotFoundException;
import com.challenge.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

 @Autowired
 private UserService userService;

 @GetMapping("/{id}")
 public ResponseEntity<User> findById (@PathVariable("id") Long id){
  return new ResponseEntity<User>(this.userService.findById(id)
  .orElseThrow(() -> new ResourceNotFoundException("Usuario não cadastrado")),HttpStatus.OK);
 }

 @GetMapping("/ByAcceleration")
 public Iterable<User> findByAccelerationName(@PathParam("nome") String nome) {
  return this.userService.findByAccelerationName(nome);
 }

 @GetMapping("/ByCompany")
 public Iterable<User> findByCompanyId(@PathParam("companyId") Long companyId) {
  return this.userService.findByCompanyId(companyId);
 }

 
}