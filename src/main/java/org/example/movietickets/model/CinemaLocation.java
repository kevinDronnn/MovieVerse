package org.example.movietickets.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cinema_location")
public class CinemaLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String location;

    public CinemaLocation() {
    }

    public CinemaLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CinemaLocation{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}
