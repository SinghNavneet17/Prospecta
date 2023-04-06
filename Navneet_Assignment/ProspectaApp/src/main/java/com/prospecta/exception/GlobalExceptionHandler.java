package com.prospecta.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	
    @ExceptionHandler(EntryException.class)
    public ResponseEntity<MyErrorDetails> customerExceptionHandler(EntryException e, WebRequest req){

        MyErrorDetails err = new MyErrorDetails(e.getMessage(), req.getDescription(false), LocalDateTime.now());
        
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler(EntryException e, WebRequest req){

        MyErrorDetails err = new MyErrorDetails(e.getMessage(), req.getDescription(false), LocalDateTime.now());
        
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    
    
}


