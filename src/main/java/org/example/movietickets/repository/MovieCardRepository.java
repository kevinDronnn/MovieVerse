package org.example.movietickets.repository;

import org.example.movietickets.model.MovieCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository for movie
 *
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.0
 */
public interface MovieCardRepository extends JpaRepository<MovieCard, Integer> {

    /**
     * Method for finding movies by current city
     * Query returns movies by id of city
     *
     * @param location name of city
     * @return list of movies
     */
    @Query("SELECT m FROM MovieCard m " +
            "JOIN Screening s ON m.id = s.movie.id " +
            "JOIN CinemaLocation cl ON s.cinemaLocation.id = cl.id " +
            "WHERE cl.location = :location")
    List<MovieCard> findMoviesByLocation(@Param("location") String location);
}

