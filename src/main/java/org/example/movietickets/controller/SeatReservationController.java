package org.example.movietickets.controller;

import org.example.movietickets.dto.SeatReservationDto;
import org.example.movietickets.service.SeatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for Seat Reservation for movies schedules
 *
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.5
 */
@RestController
@CrossOrigin("*")
@RequestMapping("api/cinema")
public class SeatReservationController {

    @Autowired
    private SeatReservationService seatReservationService;

    /**
     * Method send reservations by movieScheduleId
     *
     * @param movieScheduleId id of schedule
     * @return status 200 and list SeatReservationDto
     */
    @GetMapping("/getBySchedule/{movieScheduleId}")
    public ResponseEntity<List<SeatReservationDto>> getReservationsBySchedule(@PathVariable int movieScheduleId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(seatReservationService.getReservationsByScheduleId(movieScheduleId));
    }

    /**
     * Method for reserving seats at schedule
     *
     * @param seatReservationDto list of seats
     * @return list of seats and status 201
     */
    @PostMapping("/reserve")
    public ResponseEntity<List<SeatReservationDto>> reserveSeat(@RequestBody List<SeatReservationDto> seatReservationDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(seatReservationService.reserveSeats(seatReservationDto));
    }

    /**
     * Method for canceling reservation
     *
     * @param id of reservation
     * @return status code 204
     */
    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable int id) {
        seatReservationService.cancelReservation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

