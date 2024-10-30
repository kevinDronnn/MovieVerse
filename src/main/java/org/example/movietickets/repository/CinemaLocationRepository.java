package org.example.movietickets.repository;

import org.example.movietickets.model.CinemaLocation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for locations of cinemas
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.0
 */
public interface CinemaLocationRepository extends JpaRepository<CinemaLocation, Integer> {
        /**
         * Method for checking existing cinema location
         * @param locationName name of the city
         * @return true if we have current city in database
         */
        boolean existsByLocation(String locationName);
}
