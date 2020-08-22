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

 @GetMapping
 public Iterable<User> findAll(@PathParam("accelerationName") String accelerationName,
                               @PathParam("companyId") Long companyId) {
  if (accelerationName != null) {
   return this.userService.findByAccelerationName(accelerationName);
  } else if (companyId != null) {
   return this.userService.findByCompanyId(companyId);
  }
  return null;
 }
}