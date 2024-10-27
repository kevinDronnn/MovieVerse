package org.example.movietickets.repository;

import org.example.movietickets.model.MovieCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieCardRepository extends JpaRepository<MovieCard, Integer> {
    @Query("SELECT m FROM MovieCard m " +
            "JOIN Screening s ON m.id = s.movie.id " +
            "JOIN CinemaLocation cl ON s.cinemaLocation.id = cl.id " +
            "WHERE cl.location = :location")
    List<MovieCard> findMoviesByLocation(@Param("location") String location);
}

