package org.example.movietickets.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.movietickets.Exceptions.LocationNotFoundException;
import org.example.movietickets.dto.MovieCardDto;
import org.example.movietickets.mapper.MovieCardMapper;
import org.example.movietickets.model.MovieCard;
import org.example.movietickets.repository.CinemaLocationRepository;
import org.example.movietickets.repository.MovieCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service for movie
 * @author Artem Voroshylin
 * @version 1.1
 * @since 1.0
 */
@Service
public class MovieCardService {
    @Autowired
    private MovieCardRepository movieCardRepository;

    @Autowired
    private CinemaLocationRepository cinemaLocationRepository;

    /**
     * Method is finding movies by cities, but firstly checking if city exists
     * after that return mapped list
     * @param location of current cinema
     * @return list of movies dto`s
     * @see CinemaLocationRepository
     * @see LocationNotFoundException
     * @see MovieCardRepository
     * @see org.example.movietickets.mapper.CinemaLocationMapper
     */
    public List<MovieCardDto> findMoviesByLocation(String location) {
        String trimmedLocation = location.trim();
        if (!cinemaLocationRepository.existsByLocation(trimmedLocation)) {
            throw new LocationNotFoundException(trimmedLocation);
        }

        List<MovieCard> movieCardList = movieCardRepository.findMoviesByLocation(trimmedLocation);
        if (movieCardList.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return MovieCardMapper.INSTANCE.toMovieCardDtoList(movieCardList);
    }

}
