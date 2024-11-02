package org.example.movietickets.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
/**
 * Entity for screening time
 * @author Artem Voroshylin
 * @version 1.1
 * @since 1.1
 * @see MovieCard
 * @see CinemaLocation
 */
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

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;

    public Screening() {
    }

    public Screening(MovieCard movie, CinemaLocation cinemaLocation, Timestamp endDate, Timestamp startDate) {
        this.movie = movie;
        this.cinemaLocation = cinemaLocation;
        this.endDate = endDate;
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

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp screeningTime) {
        this.endDate = screeningTime;
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
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
