package org.example.movietickets.repository;

import org.example.movietickets.model.MovieSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for MovieSchedule
 *
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.4
 */
public interface MovieScheduleRepository extends JpaRepository<MovieSchedule, Integer> {

    /**
     * Method finds all schedules by movie and cinema
     *
     * @param movieId          id of movie
     * @param cinemaLocationId if of cinema
     * @return list of MovieSchedule
     */
    List<MovieSchedule> findByMovieIdAndCinemaLocationId(int movieId, int cinemaLocationId);
}
