package com.example.demo.exception
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(ResourceNotFoundException.class){
        public ResponseEntity<string> handleNotFound(ResponseNotFoundException ex){
            return new ResponseEntity
        }
    }
}