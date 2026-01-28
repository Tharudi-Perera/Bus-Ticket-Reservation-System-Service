package com.busreservation.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Response DTO for seat availability check.
 * 
 * Example JSON:
 * {
 *   "available": true,
 *   "availableSeats": ["1A", "1B", "2A", "2B"],
 *   "requestedSeats": 2,
 *   "pricePerSeat": 100.0,
 *   "totalPrice": 200.0,
 *   "origin": "A",
 *   "destination": "C"
 * }
 */
public class AvailabilityResponse {
    private boolean available;
    private List<String> availableSeats;
    private int requestedSeats;
    private double pricePerSeat;
    private double totalPrice;
    private String origin;
    private String destination;
    private String message;

    public AvailabilityResponse() {
        this.availableSeats = new ArrayList<>();
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<String> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<String> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getRequestedSeats() {
        return requestedSeats;
    }

    public void setRequestedSeats(int requestedSeats) {
        this.requestedSeats = requestedSeats;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(double pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AvailabilityResponse{" +
                "available=" + available +
                ", availableSeats=" + availableSeats.size() +
                ", totalPrice=" + totalPrice +
                '}';
    }
}