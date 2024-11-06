package org.example.movietickets.controller;

import org.example.movietickets.dto.MovieCardDto;
import org.example.movietickets.service.MovieCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for movies
 *
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.0
 */
@RestController
@CrossOrigin("*")
@RequestMapping("api/cinema")
public class MovieCardController {

    @Autowired
    private MovieCardService movieCardService;

    /**
     * This method is using for searching movies by city
     *
     * @param location is using for searching movies by city
     * @return list of movies dto`s and httpStatus.Ok
     * @see MovieCardService
     */
    @GetMapping("/movies")
    public ResponseEntity<List<MovieCardDto>> findMoviesByLocation(@RequestParam String location) {
        List<MovieCardDto> movies = movieCardService.findMoviesByLocation(location);
        return ResponseEntity.ok(movies);
    }

}


