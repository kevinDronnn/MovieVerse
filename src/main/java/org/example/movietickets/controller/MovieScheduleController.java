package org.example.movietickets.controller;

import org.example.movietickets.dto.MovieScheduleDto;
import org.example.movietickets.model.MovieSchedule;
import org.example.movietickets.service.MovieScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cinema")
public class MovieScheduleController {
    @Autowired
    MovieScheduleService movieScheduleService;

    @GetMapping("/getMovieSchedule/{movieId}/{locationId}")
    public ResponseEntity<List<MovieScheduleDto>> getMovieSchedule(@PathVariable int movieId,@PathVariable int locationId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieScheduleService.getSchedulesByMovieIdAndLocationId(movieId, locationId));
    }

    @PostMapping("/saveMovieSchedule")
    public ResponseEntity<MovieScheduleDto> addMovieSchedule(@RequestBody MovieSchedule movieSchedule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieScheduleService.saveSchedule(movieSchedule));
    }

    @PutMapping("/updateMovieSchedule")
    public ResponseEntity<MovieScheduleDto> updateMovieSchedule(@RequestBody MovieSchedule movieSchedule) {
        return ResponseEntity.status(HttpStatus.OK).body(movieScheduleService.updateSchedule(movieSchedule));
    }

    @DeleteMapping("/deleteMovieSchedule/{id}")
    public void deleteMovieSchedule(@PathVariable int id) {
        movieScheduleService.deleteSchedule(id);
    }

}
