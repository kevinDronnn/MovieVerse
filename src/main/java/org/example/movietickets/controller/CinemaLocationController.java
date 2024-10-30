package org.example.movietickets.controller;

import org.example.movietickets.dto.CinemaLocationDto;
import org.example.movietickets.service.CinemaLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for locations of cinemas
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("api/cinema")
@CrossOrigin("*")
public class CinemaLocationController {

    @Autowired
    CinemaLocationService service;

    /**
     * find all locations
     * @return list of cinema locations dto`s and return httpStatus.Ok
     * @see CinemaLocationService
     */
    @GetMapping("/location")
    public ResponseEntity<List<CinemaLocationDto>> getAllCinemaLocations() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
