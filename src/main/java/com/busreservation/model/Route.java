package com.busreservation.model;

import java.util.Objects;

/**
 * Represents a route between two locations.
 * Immutable class for thread safety.
 */
public final class Route {
    private final Location origin;
    private final Location destination;

    public Route(Location origin, Location destination) {
        if (origin == null || destination == null) {
            throw new IllegalArgumentException("Origin and destination cannot be null");
        }
        if (origin == destination) {
            throw new IllegalArgumentException("Origin and destination must be different");
        }
        this.origin = origin;
        this.destination = destination;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }

    /**
     * Calculates the number of stops between origin and destination
     */
    public int getStops() {
        return Math.abs(destination.ordinal() - origin.ordinal());
    }

    /**
     * Checks if this route overlaps with another route.
     * Used to prevent double-booking seats.
     * 
     * Example: Route A→C overlaps with B→D (they both use segment B→C)
     */
    public boolean overlapsWith(Route other) {
        int thisStart = Math.min(this.origin.ordinal(), this.destination.ordinal());
        int thisEnd = Math.max(this.origin.ordinal(), this.destination.ordinal());
        int otherStart = Math.min(other.origin.ordinal(), other.destination.ordinal());
        int otherEnd = Math.max(other.origin.ordinal(), other.destination.ordinal());

        // Check if ranges overlap
        return !(thisEnd <= otherStart || otherEnd <= thisStart);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return origin == route.origin && destination == route.destination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, destination);
    }

    @Override
    public String toString() {
        return origin + " → " + destination;
    }
}