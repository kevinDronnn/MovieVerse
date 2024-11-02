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
    private Timestamp startDate;
    private Timestamp endDate;

    public ScreeningDto() {
    }

    public ScreeningDto(int id, int movieId, String movieTitle, int cinemaLocationId, String cinemaLocationName, Timestamp endDate, Timestamp startDate) {
        this.id = id;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.cinemaLocationId = cinemaLocationId;
        this.cinemaLocationName = cinemaLocationName;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
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
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
