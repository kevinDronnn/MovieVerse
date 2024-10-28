package org.example.movietickets.controller;

import org.example.movietickets.dto.MovieCardDto;
import org.example.movietickets.service.MovieCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cinema")
public class MovieCardController {

    @Autowired
    private MovieCardService movieCardService;

    @GetMapping("/movies")
    public ResponseEntity<List<MovieCardDto>> findMoviesByLocation(@RequestParam String location) {
        List<MovieCardDto> movies = movieCardService.findMoviesByLocation(location);
        return ResponseEntity.ok(movies);
    }

}


