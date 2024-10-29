package org.example.movietickets.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "screening")
public class Screening {

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

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    public Screening() {
    }

    public Screening(MovieCard movie, CinemaLocation cinemaLocation, Timestamp screeningTime, Timestamp startDate) {
        this.movie = movie;
        this.cinemaLocation = cinemaLocation;
        this.screeningTime = screeningTime;
        this.startDate = startDate;
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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "id=" + id +
                ", movie=" + movie +
                ", cinemaLocation=" + cinemaLocation +
                ", screeningTime=" + screeningTime +
                ", startDate=" + startDate +
                '}';
    }
}
