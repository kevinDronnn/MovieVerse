package org.example.movietickets.repository;

import org.example.movietickets.model.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatReservationRepository extends JpaRepository<SeatReservation, Integer> {
    List<SeatReservation> findByMovieScheduleId(int movieScheduleId);

    Optional<SeatReservation> findByMovieScheduleIdAndSeatRowAndSeatNumber(int movieScheduleId, int seatRow, int seatNumber);
}
