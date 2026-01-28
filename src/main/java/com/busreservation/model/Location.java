package com.busreservation.model;

/**
 * Represents the four bus stop locations.
 * The bus travels: A → B → C → D (and reverse for return journey)
 */
public enum Location {
    A("Location A"),
    B("Location B"),
    C("Location C"),
    D("Location D");

    private final String displayName;

    Location(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    /**
     * Validates if a location string is valid
     */
    public static boolean isValid(String location) {
        if (location == null || location.trim().isEmpty()) {
            return false;
        }
        try {
            Location.valueOf(location.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Safely converts string to Location enum
     */
    public static Location fromString(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty");
        }
        try {
            return Location.valueOf(location.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid location: " + location + 
                ". Valid locations are: A, B, C, D");
        }
    }
}