package org.example.movietickets.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * Class for MovieSchedule
 *
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.4
 */
@Entity
@Table(name = "movie_screening_schedule")
public class MovieSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieCard movie;

    @ManyToOne
    @JoinColumn(name = "cinema_location_id", nullable = false)
    private CinemaLocation cinemaLocation;

    @Column(name = "screening_time", nullable = false)
    private Timestamp screeningTime;

    public MovieSchedule() {
    }

    public MovieSchedule(MovieCard movie, CinemaLocation cinemaLocation, Timestamp screeningTime) {
        this.movie = movie;
        this.cinemaLocation = cinemaLocation;
        this.screeningTime = screeningTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MovieCard getMovie() {
        return movie;
    }

    public void setMovie(MovieCard movie) {
        this.movie = movie;
    }

    public CinemaLocation getCinemaLocation() {
        return cinemaLocation;
    }

    public void setCinemaLocation(CinemaLocation cinemaLocation) {
        this.cinemaLocation = cinemaLocation;
    }

    public Timestamp getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(Timestamp screeningTime) {
        this.screeningTime = screeningTime;
    }

    @Override
    public String toString() {
        return "MovieSchedule{" +
                "id=" + id +
                ", movie=" + movie +
                ", cinemaLocation=" + cinemaLocation +
                ", screeningTime=" + screeningTime +
                '}';
    }
}
