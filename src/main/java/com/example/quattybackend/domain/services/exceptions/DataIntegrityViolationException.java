package com.example.quattybackend.domain.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException{

    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
