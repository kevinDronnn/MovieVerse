package org.example.movietickets.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.movietickets.Exceptions.LocationNotFoundException;
import org.example.movietickets.dto.MovieCardDto;
import org.example.movietickets.model.CinemaLocation;
import org.example.movietickets.model.MovieCard;
import org.example.movietickets.repository.CinemaLocationRepository;
import org.example.movietickets.repository.MovieCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class MovieCardServiceTest {
    @InjectMocks
    MovieCardService service;

    @Mock
    MovieCardRepository movieCardRepository;

    @Mock
    CinemaLocationRepository cinemaLocationRepository;

    List<MovieCard> movieCardDtoList;
    @BeforeEach
    void setUp() {
        movieCardDtoList =
                List.of(new MovieCard());
    }

    @DisplayName("get all movies by locations")
    @ParameterizedTest
    @ValueSource(strings = {"Odesa", "Kyiv", "Lviv"})
    void testGetAllMoviesByLocation_returnsListOfMovies(String location) {
        when(cinemaLocationRepository.existsByLocation(location)).thenReturn(true);
        when(movieCardRepository.findMoviesByLocation(location)).thenReturn(movieCardDtoList);

        List<MovieCardDto> movieList = service.findMoviesByLocation(location);

        assertNotNull(movieList,"Expected a non-empty list of movies");
        verify(cinemaLocationRepository, times(1)).existsByLocation(location);
        verify(movieCardRepository, times(1)).findMoviesByLocation(location);
    }

    @DisplayName("throws LocationNotFoundException if location does not exist")
    @Test
    void testGetAllMoviesByInvalidLocation_throwsLocationNotFoundException() {
        String location = "  NonExistentLocation  ";
        String trimmedLocation = location.trim();

        when(cinemaLocationRepository.existsByLocation(trimmedLocation)).thenReturn(false);

        assertThrows(LocationNotFoundException.class, () -> service.findMoviesByLocation(location),
                "Expected LocationNotFoundException for a non-existent location");

        verify(cinemaLocationRepository, times(1)).existsByLocation(trimmedLocation);
        verify(movieCardRepository, never()).findMoviesByLocation(trimmedLocation);
    }


    @DisplayName("throws EntityNotFoundException if no movies found for existing location")
    @Test
    void testGetAllMoviesByLocationWithNoMovies_throwsEntityNotFoundException() {
        String location = "Odesa";

        when(cinemaLocationRepository.existsByLocation(location)).thenReturn(true);
        when(movieCardRepository.findMoviesByLocation(location)).thenReturn(Collections.emptyList());

        assertThrows(EntityNotFoundException.class, () -> service.findMoviesByLocation(location),
                "Expected EntityNotFoundException when no movies are found");

        verify(cinemaLocationRepository, times(1)).existsByLocation(location);
        verify(movieCardRepository, times(1)).findMoviesByLocation(location);
    }
}