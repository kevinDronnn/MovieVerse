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

@Service
public class MovieCardService {
    @Autowired
    private MovieCardRepository movieCardRepository;

    @Autowired
    private CinemaLocationRepository cinemaLocationRepository;

    public List<MovieCardDto> findMoviesByLocation(String location) {
        String trimmedLocation = location.trim();
        List<MovieCard> movieCardList = movieCardRepository.findMoviesByLocation(trimmedLocation);

        if (!cinemaLocationRepository.existsByLocation(trimmedLocation)) {
            throw new LocationNotFoundException(trimmedLocation);
        } else if (movieCardList.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return MovieCardMapper.INSTANCE.toMovieCardDtoList(movieCardList);
    }
}
