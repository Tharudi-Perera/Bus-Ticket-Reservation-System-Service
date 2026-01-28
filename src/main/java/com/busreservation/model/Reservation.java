package com.busreservation.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents a bus ticket reservation.
 * Immutable class for thread safety.
 */
public final class Reservation {
    private final String reservationNumber;
    private final Route route;
    private final List<Seat> seats;
    private final double totalPrice;
    private final LocalDateTime reservationTime;

    private Reservation(Builder builder) {
        this.reservationNumber = builder.reservationNumber;
        this.route = builder.route;
        this.seats = Collections.unmodifiableList(new ArrayList<>(builder.seats));
        this.totalPrice = builder.totalPrice;
        this.reservationTime = builder.reservationTime;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public Route getRoute() {
        return route;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int getPassengerCount() {
        return seats.size();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(reservationNumber, that.reservationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationNumber);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "number='" + reservationNumber + '\'' +
                ", route=" + route +
                ", seats=" + seats +
                ", price=" + totalPrice +
                '}';
    }

    /**
     * Builder pattern for creating Reservation objects
     */
    public static class Builder {
        private String reservationNumber;
        private Route route;
        private List<Seat> seats = new ArrayList<>();
        private double totalPrice;
        private LocalDateTime reservationTime;

        public Builder reservationNumber(String reservationNumber) {
            this.reservationNumber = reservationNumber;
            return this;
        }

        public Builder route(Route route) {
            this.route = route;
            return this;
        }

        public Builder seats(List<Seat> seats) {
            this.seats = new ArrayList<>(seats);
            return this;
        }

        public Builder addSeat(Seat seat) {
            this.seats.add(seat);
            return this;
        }

        public Builder totalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder reservationTime(LocalDateTime reservationTime) {
            this.reservationTime = reservationTime;
            return this;
        }

        public Reservation build() {
            // Validation
            if (reservationNumber == null || reservationNumber.trim().isEmpty()) {
                throw new IllegalStateException("Reservation number is required");
            }
            if (route == null) {
                throw new IllegalStateException("Route is required");
            }
            if (seats == null || seats.isEmpty()) {
                throw new IllegalStateException("At least one seat is required");
            }
            if (totalPrice <= 0) {
                throw new IllegalStateException("Total price must be positive");
            }
            if (reservationTime == null) {
                reservationTime = LocalDateTime.now();
            }

            return new Reservation(this);
        }
    }
}