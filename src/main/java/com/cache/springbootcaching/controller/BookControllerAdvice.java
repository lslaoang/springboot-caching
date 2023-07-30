package com.cache.springbootcaching.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeErrorHandler(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
