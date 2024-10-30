package org.example.movietickets.dto;
/**
 * Dto for locations of cinemas
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.0
 */
public class CinemaLocationDto {

    private String location;

    public CinemaLocationDto() {
    }

    public CinemaLocationDto(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CinemaLocationDto{" +
                "location='" + location + '\'' +
                '}';
    }
}
