package org.example.movietickets.dto;
/**
 * Dto for movie
 * @author Artem Voroshylin
 * @version 1.1
 * @since 1.0
 */
public class MovieCardDto {

    private String title;

    private String age;

    private int year;

    private String director;

    private String moviegoerRating;

    private String criticsRating;

    private String genre;

    private String duration;

    private String production;

    private String studio;

    private String screenplay;

    private String starring;

    private String description;

    private String trailerIframeLink;

    public MovieCardDto() {
    }

    public MovieCardDto(String title, String age, int year, String director, String moviegoerRating, String criticsRating, String genre, String duration, String production, String studio, String screenplay, String starring, String description, String trailerIframeLink) {
        this.title = title;
        this.age = age;
        this.year = year;
        this.director = director;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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
        return "MovieCardDto{" +
                "title='" + title + '\'' +
                ", age='" + age + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
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
