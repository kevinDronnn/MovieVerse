package org.example.movietickets.Exceptions;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(String location) {
        super("Location '" + location + "' not found.");
    }
}

