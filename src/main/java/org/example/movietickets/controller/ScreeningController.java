package org.example.movietickets.controller;

import org.example.movietickets.dto.ScreeningDto;
import org.example.movietickets.model.Screening;
import org.example.movietickets.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for screening of movies and locations
 *
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.1
 */
@RestController
@RequestMapping("api/cinema")
@CrossOrigin("*")
public class ScreeningController {

    @Autowired
    ScreeningService screeningService;

    /**
     * Method for saving screening
     *
     * @param screening data of screening time of movie in some location
     * @return ScreeningDto and 201 status
     */
    @PostMapping("/saveScreening")
    public ResponseEntity<ScreeningDto> saveScreening(@RequestBody Screening screening) {
        ScreeningDto savedScreening = screeningService.save(screening);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedScreening);
    }

    /**
     * Method for updating screening time of movie by id
     *
     * @param screening new time for screening
     * @param id        of screening
     * @return updated ScreeningDto and 200 status
     * @see ScreeningService
     */
    @PutMapping("/updateScreening/{id}")
    public ResponseEntity<ScreeningDto> updateScreening(@RequestBody Screening screening, @PathVariable int id) {
        ScreeningDto updatedScreening = screeningService.update(screening, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedScreening);
    }

    /**
     * Method for getting screening by location id and movie id
     *
     * @param locationId id of city where movie is in rental
     * @param movieId    id of movie what we need
     * @return updated ScreeningDto and 200 status
     * @see ScreeningService
     */
    @GetMapping("/getScreening/{locationId}/{movieId}")
    public ResponseEntity<ScreeningDto> updateScreening(@PathVariable int locationId, @PathVariable int movieId) {
        return ResponseEntity.status(HttpStatus.OK).body(screeningService.findScreeningByLocationIdAndMovieId(locationId, movieId));
    }

    /**
     * Method delete screening
     *
     * @param id of screening
     */
    @DeleteMapping("/deleteScreening/{id}")
    public void deleteScreening(@PathVariable int id) {
        screeningService.deleteScreening(id);
    }
}
