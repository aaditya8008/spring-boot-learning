package com.example.crudspringbootdemo.dto;

import java.time.LocalDateTime;

public class ExceptionResponseDTO {
    private String message;
    private int statusCode;
    private String error;
    private String path;
    private LocalDateTime timestamp;
    public ExceptionResponseDTO(String message, int statusCode, String error, String path, LocalDateTime timestamp) {
        this.message = message;
        this.statusCode = statusCode;
        this.error = error;
        this.path = path;
        this.timestamp = timestamp;
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
}
