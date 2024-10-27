package org.example.movietickets.repository;

import org.example.movietickets.model.CinemaLocation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CinemaLocationRepository extends JpaRepository<CinemaLocation, Integer> {
        boolean existsByLocation(String locationName);
}
