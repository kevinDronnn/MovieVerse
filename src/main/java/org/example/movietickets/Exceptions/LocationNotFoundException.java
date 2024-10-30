package org.example.movietickets.Exceptions;
/**
 * Own exception for locations
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.1
 */
public class LocationNotFoundException extends RuntimeException {
    /**
     * Method return message when location not found
     * @param location message of exception
     */
    public LocationNotFoundException(String location) {
        super("Location '" + location + "' not found.");
    }
}

