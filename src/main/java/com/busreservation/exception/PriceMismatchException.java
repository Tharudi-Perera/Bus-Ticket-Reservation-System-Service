package com.busreservation.exception;

/**
 * Thrown when the price confirmed by user doesn't match calculated price
 */
public class PriceMismatchException extends BusinessException {
    private final double expectedPrice;
    private final double providedPrice;

    public PriceMismatchException(double expectedPrice, double providedPrice) {
        super(String.format("Price mismatch. Expected: Rs. %.2f, Provided: Rs. %.2f", 
            expectedPrice, providedPrice));
        this.expectedPrice = expectedPrice;
        this.providedPrice = providedPrice;
    }

    public double getExpectedPrice() {
        return expectedPrice;
    }

    public double getProvidedPrice() {
        return providedPrice;
    }
}