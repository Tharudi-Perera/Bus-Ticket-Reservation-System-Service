package com.busreservation.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Response DTO for successful reservation.
 * 
 * Example JSON:
 * {
 *   "success": true,
 *   "reservationNumber": "RES-1001",
 *   "assignedSeats": ["1A", "1B"],
 *   "origin": "A",
 *   "destination": "C",
 *   "totalPrice": 200.0,
 *   "reservationTime": "2026-01-28T10:30:00",
 *   "message": "Reservation successful"
 * }
 */
public class ReservationResponse {
    private boolean success;
    private String reservationNumber;
    private List<String> assignedSeats;
    private String origin;
    private String destination;
    private double totalPrice;
    private String reservationTime;
    private String message;

    public ReservationResponse() {
        this.assignedSeats = new ArrayList<>();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public List<String> getAssignedSeats() {
        return assignedSeats;
    }

    public void setAssignedSeats(List<String> assignedSeats) {
        this.assignedSeats = assignedSeats;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ReservationResponse{" +
                "success=" + success +
                ", reservationNumber='" + reservationNumber + '\'' +
                ", assignedSeats=" + assignedSeats +
                ", totalPrice=" + totalPrice +
                '}';
    }
}