package com.gustavo.crudspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gustavo.crudspring.exception.RegistryNotFoundException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

  @ExceptionHandler(RegistryNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleNotFoundException(RegistryNotFoundException ex) {
    return ex.getMessage();
  }
}
