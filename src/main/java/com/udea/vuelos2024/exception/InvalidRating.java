package com.udea.vuelos2024.exception;

public class InvalidRating extends RuntimeException {
    public InvalidRating(String message) {
        super(message);
    }
}
