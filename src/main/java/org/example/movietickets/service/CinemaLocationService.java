package org.example.movietickets.service;

import org.example.movietickets.dto.CinemaLocationDto;
import org.example.movietickets.mapper.CinemaLocationMapper;
import org.example.movietickets.repository.CinemaLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for cinema location
 *
 * @author Artem Voroshylin
 * @version 1.1
 * @since 1.0
 */
@Service
public class CinemaLocationService {

    @Autowired
    private CinemaLocationRepository cinemaLocationRepository;

    /**
     * Method for finding all cinemas locations
     *
     * @return list of mapped cinemas dto`s
     * @see CinemaLocationMapper
     */
    public List<CinemaLocationDto> findAll() {
        return CinemaLocationMapper.INSTANCE.cinemaLocationToCinemaLocationDto(cinemaLocationRepository.findAll());
    }

    /**
     * Method for checking existing cinema location
     *
     * @param location name of the city
     * @return true if we have current city in database
     * @see CinemaLocationRepository
     */
    public boolean existsByLocation(String location) {
        return cinemaLocationRepository.existsByLocation(location);
    }
}
