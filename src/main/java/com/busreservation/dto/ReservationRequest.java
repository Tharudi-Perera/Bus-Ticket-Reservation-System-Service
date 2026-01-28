package com.busreservation.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Request DTO for making a reservation.
 * 
 * Example JSON:
 * {
 *   "passengers": 2,
 *   "origin": "A",
 *   "destination": "C",
 *   "confirmedPrice": 200.0,
 *   "requestedSeats": ["1A", "1B"]  // Optional - system can auto-assign
 * }
 */
public class ReservationRequest {
    private int passengers;
    private String origin;
    private String destination;
    private double confirmedPrice;
    private List<String> requestedSeats;

    public ReservationRequest() {
        this.requestedSeats = new ArrayList<>();
    }

    public ReservationRequest(int passengers, String origin, String destination, double confirmedPrice) {
        this.passengers = passengers;
        this.origin = origin;
        this.destination = destination;
        this.confirmedPrice = confirmedPrice;
        this.requestedSeats = new ArrayList<>();
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

    public double getConfirmedPrice() {
        return confirmedPrice;
    }

    public void setConfirmedPrice(double confirmedPrice) {
        this.confirmedPrice = confirmedPrice;
    }

    public List<String> getRequestedSeats() {
        return requestedSeats;
    }

    public void setRequestedSeats(List<String> requestedSeats) {
        this.requestedSeats = requestedSeats != null ? requestedSeats : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "passengers=" + passengers +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", confirmedPrice=" + confirmedPrice +
                ", requestedSeats=" + requestedSeats +
                '}';
    }
}