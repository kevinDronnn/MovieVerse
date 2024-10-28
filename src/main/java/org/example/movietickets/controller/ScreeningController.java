package org.example.movietickets.controller;

import org.example.movietickets.dto.ScreeningDto;
import org.example.movietickets.model.Screening;
import org.example.movietickets.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cinema")
@CrossOrigin("*")
public class ScreeningController {

    @Autowired
    ScreeningService screeningService;

    @PostMapping("/saveScreening")
    public ResponseEntity<ScreeningDto> saveScreening(@RequestBody Screening screening) {
        ScreeningDto savedScreening = screeningService.save(screening);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedScreening);
    }

    @PutMapping("/updateScreening/{id}")
    public ResponseEntity<ScreeningDto> updateScreening(@RequestBody Screening screening, @PathVariable int id) {
        ScreeningDto updatedScreening = screeningService.update(screening, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedScreening);
    }

    @GetMapping("/getScreening/{locationId}/{movieId}")
    public ResponseEntity<ScreeningDto> updateScreening(@PathVariable int locationId, @PathVariable int movieId) {
        return ResponseEntity.status(HttpStatus.OK).body(screeningService.findScreeningByLocationIdAndMovieId(locationId, movieId));
    }
}
