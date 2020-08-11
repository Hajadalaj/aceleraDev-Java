package com.challenge.exceptions;

public class ResourceNotFoundException extends RuntimeException{

 public ResourceNotFoundException (String resource){
  super("Recurso: " + resource + " não encontrado!");
 }

}
