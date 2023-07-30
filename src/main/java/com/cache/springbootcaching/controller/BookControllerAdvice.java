package com.cache.springbootcaching.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<NotFoundResponse> runtimeErrorHandler(){
        NotFoundResponse response = new NotFoundResponse();
                response.setStatus("404");
                response.setMessage("Item not found.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
