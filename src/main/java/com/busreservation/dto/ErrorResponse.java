package com.busreservation.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Standard error response DTO.
 * 
 * Example JSON:
 * {
 *   "success": false,
 *   "error": "Invalid Request",
 *   "message": "Passenger count must be positive",
 *   "details": ["passengers: must be greater than 0"],
 *   "timestamp": "2026-01-28T10:30:00"
 * }
 */
public class ErrorResponse {
    private boolean success;
    private String error;
    private String message;
    private List<String> details;
    private String timestamp;

    public ErrorResponse() {
        this.success = false;
        this.details = new ArrayList<>();
        this.timestamp = LocalDateTime.now().toString();
    }

    public ErrorResponse(String error, String message) {
        this();
        this.error = error;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public void addDetail(String detail) {
        if (this.details == null) {
            this.details = new ArrayList<>();
        }
        this.details.add(detail);
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", details=" + details +
                '}';
    }
}