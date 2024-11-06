package org.example.movietickets.controller;

import org.example.movietickets.dto.MovieScheduleDto;
import org.example.movietickets.model.MovieSchedule;
import org.example.movietickets.service.MovieScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controller for MovieSchedule
 * @author Artem Voroshylin
 * @version 1.1
 * @since 1.4
 */
@RestController
@CrossOrigin("*")
@RequestMapping("api/cinema")
public class MovieScheduleController {
    @Autowired
    MovieScheduleService movieScheduleService;

    /**
     * Method select schedules
     * @param movieId id of movie
     * @param locationId if of cinema
     * @return list of MovieScheduleDto and status 200
     */
    @GetMapping("/getMovieSchedule/{movieId}/{locationId}")
    public ResponseEntity<List<MovieScheduleDto>> getMovieSchedule(@PathVariable int movieId,@PathVariable int locationId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieScheduleService.getSchedulesByMovieIdAndLocationId(movieId, locationId));
    }

    /**
     * Method save MovieSchedule
     * @param movieSchedule new schedule
     * @return new MovieScheduleDto and status 201
     */
    @PostMapping("/saveMovieSchedule")
    public ResponseEntity<MovieScheduleDto> addMovieSchedule(@RequestBody MovieSchedule movieSchedule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieScheduleService.saveSchedule(movieSchedule));
    }

    /**
     * Method updating schedule
     * @param movieSchedule new data for schedule
     * @return updated MovieScheduleDto and status 200
     */
    @PutMapping("/updateMovieSchedule")
    public ResponseEntity<MovieScheduleDto> updateMovieSchedule(@RequestBody MovieSchedule movieSchedule) {
        return ResponseEntity.status(HttpStatus.OK).body(movieScheduleService.updateSchedule(movieSchedule));
    }

    /**
     * Deleting schedule
     * @param id schedule
     */
    @DeleteMapping("/deleteMovieSchedule/{id}")
    public void deleteMovieSchedule(@PathVariable int id) {
        movieScheduleService.deleteSchedule(id);
    }

}
