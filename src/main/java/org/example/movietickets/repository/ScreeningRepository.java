package org.example.movietickets.repository;

import org.example.movietickets.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
    Screening findByCinemaLocation_IdAndMovie_Id(int cinemaLocationId, int movieId);

}
