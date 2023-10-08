package com.example.demo.advise;


import com.example.demo.apiException.ApiException;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = ExpiredJwtException.class)
    public ResponseEntity ExpiredJwtException(ExpiredJwtException e) {
        String message = e.getMessage().toString();
        return ResponseEntity.status(403).body(message);
    }
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        String message = e.getMessage().toString();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(HttpMessageNotReadableException e) {
        String message = e.getMessage().toString();
        return ResponseEntity.status(400).body(message);
    }


    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(HttpRequestMethodNotSupportedException e) {
        String message = e.getMessage().toString();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        String message = e.getMessage().toString();
        return ResponseEntity.status(400).body(message);
    }


    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(ConstraintViolationException e) {
        String message = e.getMessage().toString();
        return ResponseEntity.status(400).body(message);
    }


    @ExceptionHandler(value = IncorrectResultSizeDataAccessException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(IncorrectResultSizeDataAccessException e) {
        String message = e.getMessage().toString();
        return ResponseEntity.status(400).body(message);
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity Exception(Exception e) {
        String message = e.getMessage().toString();
        return ResponseEntity.status(400).body(message);
    }


}