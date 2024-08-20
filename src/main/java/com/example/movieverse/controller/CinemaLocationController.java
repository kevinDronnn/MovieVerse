package com.example.movieverse.controller;

import com.example.movieverse.dto.CinemaLocationDto;
import com.example.movieverse.service.CinemaLocationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/location")
@CrossOrigin(origins = "*")
public class CinemaLocationController {

    private final CinemaLocationService cinemaLocationService;

    public CinemaLocationController(CinemaLocationService cinemaLocationService) {
        this.cinemaLocationService = cinemaLocationService;
    }

    @GetMapping("/getLocations")
    List<CinemaLocationDto> getLocations() {
        return cinemaLocationService.getAllCinemaLocations();
    }
}
