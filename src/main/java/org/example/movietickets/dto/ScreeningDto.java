package org.example.movietickets.dto;

import java.sql.Timestamp;

public class ScreeningDto {
    private int id;
    private int movieId;
    private String movieTitle;
    private int cinemaLocationId;
    private String cinemaLocationName;
    private Timestamp screeningTime;

    public ScreeningDto() {
    }

    public ScreeningDto(int id, int movieId, String movieTitle, int cinemaLocationId, String cinemaLocationName, Timestamp screeningTime) {
        this.id = id;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.cinemaLocationId = cinemaLocationId;
        this.cinemaLocationName = cinemaLocationName;
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

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getCinemaLocationId() {
        return cinemaLocationId;
    }

    public void setCinemaLocationId(int cinemaLocationId) {
        this.cinemaLocationId = cinemaLocationId;
    }

    public String getCinemaLocationName() {
        return cinemaLocationName;
    }

    public void setCinemaLocationName(String cinemaLocationName) {
        this.cinemaLocationName = cinemaLocationName;
    }

    public Timestamp getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(Timestamp screeningTime) {
        this.screeningTime = screeningTime;
    }

    @Override
    public String toString() {
        return "ScreeningDto{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", cinemaLocationId=" + cinemaLocationId +
                ", cinemaLocationName='" + cinemaLocationName + '\'' +
                ", screeningTime=" + screeningTime +
                '}';
    }
}