package org.example.movietickets.dto;

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
