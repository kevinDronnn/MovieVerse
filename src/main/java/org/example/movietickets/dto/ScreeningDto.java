package org.example.movietickets.dto;

import java.sql.Timestamp;
/**
 * Dto for screening time
 * @author Artem Voroshylin
 * @version 1.1
 * @since 1.1
 */
public class ScreeningDto {
    private int id;
    private int movieId;
    private String movieTitle;
    private int cinemaLocationId;
    private String cinemaLocationName;
    private Timestamp screeningTime;
    private Timestamp startDate;

    public ScreeningDto() {
    }

    public ScreeningDto(int id, int movieId, String movieTitle, int cinemaLocationId, String cinemaLocationName, Timestamp screeningTime, Timestamp startDate) {
        this.id = id;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.cinemaLocationId = cinemaLocationId;
        this.cinemaLocationName = cinemaLocationName;
        this.screeningTime = screeningTime;
        this.startDate = startDate;
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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
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
                ", startDate=" + startDate +
                '}';
    }
}
