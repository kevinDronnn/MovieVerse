package org.example.movietickets.dto;

import java.sql.Timestamp;

public class MovieScheduleDto {
    private int id;
    private int movieId;
    private int cinemaLocationId;
    private Timestamp screeningTime;

    public MovieScheduleDto() {
    }

    public MovieScheduleDto(int id, int movieId, int cinemaLocationId, Timestamp screeningTime) {
        this.id = id;
        this.movieId = movieId;
        this.cinemaLocationId = cinemaLocationId;
        this.screeningTime = screeningTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCinemaLocationId() {
        return cinemaLocationId;
    }

    public void setCinemaLocationId(int cinemaLocationId) {
        this.cinemaLocationId = cinemaLocationId;
    }

    public Timestamp getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(Timestamp screeningTime) {
        this.screeningTime = screeningTime;
    }

    @Override
    public String toString() {
        return "MovieScheduleDto{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", cinemaLocationId=" + cinemaLocationId +
                ", screeningTime=" + screeningTime +
                '}';
    }
}
