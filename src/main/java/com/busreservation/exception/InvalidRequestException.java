package com.busreservation.exception;

/**
 * Thrown when request input is invalid
 */
public class InvalidRequestException extends BusinessException {
    public InvalidRequestException(String message) {
        super(message);
    }
}