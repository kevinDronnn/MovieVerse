package org.example.movietickets.repository;

import org.example.movietickets.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for screenings
 *
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.0
 */
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {

    /**
     * Method for finding screening time by movie and city
     *
     * @param cinemaLocationId for finding right city
     * @param movieId          for finding right movie
     * @return Screening entity
     */
    Screening findByCinemaLocation_IdAndMovie_Id(int cinemaLocationId, int movieId);

}
