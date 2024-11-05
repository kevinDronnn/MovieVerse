package org.example.movietickets.repository;

import org.example.movietickets.model.MovieSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieScheduleRepository extends JpaRepository<MovieSchedule, Integer> {
    List<MovieSchedule> findByMovieIdAndCinemaLocationId(int movieId, int cinemaLocationId);
}
