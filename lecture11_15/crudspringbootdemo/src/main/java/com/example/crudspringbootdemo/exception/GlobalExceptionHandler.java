package com.example.crudspringbootdemo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.crudspringbootdemo.dto.ExceptionResponseDTO;
import com.example.crudspringbootdemo.dto.ValidationExceptionResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice 
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleResourceNotFound(ResourceNotFoundException ex,HttpServletRequest request) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(
            ex.getMessage(),
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.getReasonPhrase(),
            request.getRequestURI(),
            LocalDateTime.now()
        );
        return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(response);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResponseDTO> handleDuplicateResource(DuplicateResourceException ex, HttpServletRequest request) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(
            ex.getMessage(),
            HttpStatus.CONFLICT.value(),
            HttpStatus.CONFLICT.getReasonPhrase(),
            request.getRequestURI(),
            LocalDateTime.now()
        );
        return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(response);
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDTO> handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(
            ex.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
            request.getRequestURI(),
            LocalDateTime.now()
        );
        return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleGenericException(Exception ex, HttpServletRequest request) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(
            ex.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
            request.getRequestURI(),
            LocalDateTime.now()
        );
        return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
        .forEach(error -> 
            fieldErrors.put(error.getField(), error.getDefaultMessage()));
        ValidationExceptionResponseDTO response = new ValidationExceptionResponseDTO(
            "Validation failed",
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            request.getRequestURI(),
            LocalDateTime.now(),
            fieldErrors
        );
        return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(response);
    }
    
}
