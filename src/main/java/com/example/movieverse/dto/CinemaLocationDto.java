package com.example.movieverse.dto;

public class CinemaLocationDto {

    String location;

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
