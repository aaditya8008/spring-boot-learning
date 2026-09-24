package com.example.crudspringbootdemo.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionResponseDTO {
    private String message;
    private int statusCode;
    private String error;
    private String path;
    private LocalDateTime timestamp;
    private Map<String, String> fieldErrors;
    public ValidationExceptionResponseDTO(String message, int statusCode, String error, String path,
            LocalDateTime timestamp, Map<String, String> fieldErrors) {
        this.message = message;
        this.statusCode = statusCode;
        this.error = error;
        this.path = path;
        this.timestamp = timestamp;
        this.fieldErrors = fieldErrors;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
    
}
