package com.busreservation.exception;

/**
 * Thrown when requested seats are not available
 */
public class SeatNotAvailableException extends BusinessException {
    public SeatNotAvailableException(String message) {
        super(message);
    }
}