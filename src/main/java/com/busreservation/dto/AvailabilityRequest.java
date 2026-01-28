package com.busreservation.dto;

/**
 * Request DTO for checking seat availability.
 * 
 * Example JSON:
 * {
 *   "passengers": 2,
 *   "origin": "A",
 *   "destination": "C"
 * }
 */
public class AvailabilityRequest {
    private int passengers;
    private String origin;
    private String destination;

    // No-arg constructor for JSON deserialization
    public AvailabilityRequest() {
    }

    public AvailabilityRequest(int passengers, String origin, String destination) {
        this.passengers = passengers;
        this.origin = origin;
        this.destination = destination;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
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

    @Override
    public String toString() {
        return "AvailabilityRequest{" +
                "passengers=" + passengers +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}