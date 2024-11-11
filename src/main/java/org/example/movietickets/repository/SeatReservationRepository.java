package org.example.movietickets.repository;

import org.example.movietickets.model.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for SeatReservation
 *
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.5
 */
public interface SeatReservationRepository extends JpaRepository<SeatReservation, Integer> {
    /**
     * Method for finding list of reservations
     *
     * @param movieScheduleId id of schedule
     * @return List<SeatReservation>
     */
    List<SeatReservation> findByMovieScheduleId(int movieScheduleId);

    /**
     * Method for finding needed reservation
     *
     * @param movieScheduleId id of schedule
     * @param seatRow         number of raw
     * @param seatNumber      number of seat
     * @return Optional<SeatReservation>
     */
    Optional<SeatReservation> findByMovieScheduleIdAndSeatRowAndSeatNumber(int movieScheduleId, int seatRow, int seatNumber);
}
