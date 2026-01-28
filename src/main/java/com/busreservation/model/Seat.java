package com.busreservation.model;

import java.util.Objects;

/**
 * Represents a seat in the bus.
 * Bus has 40 seats: 10 rows × 4 columns (A, B, C, D)
 * Example: 1A, 1B, 1C, 1D, 2A, ..., 10D
 * 
 * Immutable class for thread safety.
 */
public final class Seat implements Comparable<Seat> {
    private final int row;        // 1 to 10
    private final char column;    // A, B, C, D
    private final String seatNumber;

    public Seat(int row, char column) {
        validateRow(row);
        validateColumn(column);
        this.row = row;
        this.column = Character.toUpperCase(column);
        this.seatNumber = row + String.valueOf(this.column);
    }

    public Seat(String seatNumber) {
        if (seatNumber == null || seatNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Seat number cannot be null or empty");
        }
        
        seatNumber = seatNumber.trim().toUpperCase();
        
        // Parse row number (all digits at start)
        int i = 0;
        while (i < seatNumber.length() && Character.isDigit(seatNumber.charAt(i))) {
            i++;
        }
        
        if (i == 0 || i == seatNumber.length()) {
            throw new IllegalArgumentException("Invalid seat number format: " + seatNumber);
        }
        
        try {
            this.row = Integer.parseInt(seatNumber.substring(0, i));
            this.column = seatNumber.charAt(i);
            
            validateRow(this.row);
            validateColumn(this.column);
            
            this.seatNumber = this.row + String.valueOf(this.column);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid seat number format: " + seatNumber);
        }
    }

    private void validateRow(int row) {
        if (row < 1 || row > 10) {
            throw new IllegalArgumentException("Row must be between 1 and 10, got: " + row);
        }
    }

    private void validateColumn(char column) {
        char upper = Character.toUpperCase(column);
        if (upper < 'A' || upper > 'D') {
            throw new IllegalArgumentException("Column must be A, B, C, or D, got: " + column);
        }
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public int compareTo(Seat other) {
        if (this.row != other.row) {
            return Integer.compare(this.row, other.row);
        }
        return Character.compare(this.column, other.column);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return row == seat.row && column == seat.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return seatNumber;
    }
}