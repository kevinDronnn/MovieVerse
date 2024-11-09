package org.example.movietickets.controller;

import org.example.movietickets.dto.SeatReservationDto;
import org.example.movietickets.service.SeatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cinema")
public class SeatReservationController {

    @Autowired
    private SeatReservationService seatReservationService;

    @GetMapping("/getBySchedule/{movieScheduleId}")
    public ResponseEntity<List<SeatReservationDto>> getReservationsBySchedule(@PathVariable int movieScheduleId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(seatReservationService.getReservationsByScheduleId(movieScheduleId));
    }

    @PostMapping("/reserve")
    public ResponseEntity<List<SeatReservationDto>> reserveSeat(@RequestBody List<SeatReservationDto> seatReservationDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(seatReservationService.reserveSeats(seatReservationDto));
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable int id) {
        seatReservationService.cancelReservation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

