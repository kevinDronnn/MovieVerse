package com.example.movieverse.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "movie_info")
public class MovieCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String age;

    private LocalDate year;

    private String director;

    @Column(name = "distribution_period")
    private String distributionPeriod;

    @Column(name = "moviegoer_rating")
    private String moviegoerRating;

    @Column(name = "critics_rating")
    private String criticsRating;

    private String genre;

    private String duration;

    private String production;

    private String studio;

    private String screenplay;

    private String starring;

    private String description;

    @Column(name = "trailer_iframe_link")
    private String trailerIframeLink;

    public MovieCard() {
    }

    public MovieCard(String title, String age, LocalDate year, String director, String distributionPeriod, String moviegoerRating, String criticsRating, String genre, String duration, String production, String studio, String screenplay, String starring, String description, String trailerIframeLink) {
        this.title = title;
        this.age = age;
        this.year = year;
        this.director = director;
        this.distributionPeriod = distributionPeriod;
        this.moviegoerRating = moviegoerRating;
        this.criticsRating = criticsRating;
        this.genre = genre;
        this.duration = duration;
        this.production = production;
        this.studio = studio;
        this.screenplay = screenplay;
        this.starring = starring;
        this.description = description;
        this.trailerIframeLink = trailerIframeLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDistributionPeriod() {
        return distributionPeriod;
    }

    public void setDistributionPeriod(String distributionPeriod) {
        this.distributionPeriod = distributionPeriod;
    }

    public String getMoviegoerRating() {
        return moviegoerRating;
    }

    public void setMoviegoerRating(String moviegoerRating) {
        this.moviegoerRating = moviegoerRating;
    }

    public String getCriticsRating() {
        return criticsRating;
    }

    public void setCriticsRating(String criticsRating) {
        this.criticsRating = criticsRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getScreenplay() {
        return screenplay;
    }

    public void setScreenplay(String screenplay) {
        this.screenplay = screenplay;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrailerIframeLink() {
        return trailerIframeLink;
    }

    public void setTrailerIframeLink(String trailerIframeLink) {
        this.trailerIframeLink = trailerIframeLink;
    }

    @Override
    public String toString() {
        return "MovieCard{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", age='" + age + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", distributionPeriod='" + distributionPeriod + '\'' +
                ", moviegoerRating='" + moviegoerRating + '\'' +
                ", criticsRating='" + criticsRating + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                ", production='" + production + '\'' +
                ", studio='" + studio + '\'' +
                ", screenplay='" + screenplay + '\'' +
                ", starring='" + starring + '\'' +
                ", description='" + description + '\'' +
                ", trailerIframeLink='" + trailerIframeLink + '\'' +
                '}';
    }
}
