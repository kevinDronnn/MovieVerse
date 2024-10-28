package org.example.movietickets.service;

import org.example.movietickets.dto.CinemaLocationDto;
import org.example.movietickets.mapper.CinemaLocationMapper;
import org.example.movietickets.model.CinemaLocation;
import org.example.movietickets.repository.CinemaLocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CinemaLocationServiceTest {

    @InjectMocks
    CinemaLocationService service;

    @Mock
    CinemaLocationRepository repository;

    List<CinemaLocation> cinemaLocations;

    @BeforeEach
    void setUp() {
        cinemaLocations =
                List.of(new CinemaLocation("Odesa"),
                        new CinemaLocation("Kyiv"),
                        new CinemaLocation("Lviv"));
    }

    @DisplayName("ExistsByLocation should return true if city exists, false otherwise")
    @ParameterizedTest
    @ValueSource(strings = {"Odesa", "Kyiv", "Lviv", "NonExistentCity"})
    void testExistsByLocation_returnsCorrectBoolean(String city) {
        when(repository.existsByLocation(city)).thenReturn(city.equals("Odesa") || city.equals("Kyiv") || city.equals("Lviv"));

        boolean result = service.existsByLocation(city);

        if (city.equals("Odesa") || city.equals("Kyiv") || city.equals("Lviv")) {
            assertTrue(result, "Expected city to exist in the database");
        } else {
            assertFalse(result, "Expected city not to exist in the database");
        }

        verify(repository, times(1)).existsByLocation(city);
    }

    @DisplayName("get all locations of cinemas")
    @Test
    void testFindAll_returnsListOfCinemas() {
        when(repository.findAll()).thenReturn(cinemaLocations);

        List<CinemaLocationDto> result = service.findAll();

        assertFalse(result.isEmpty(), "Expected a non-empty list of cinemas");
        verify(repository, times(1)).findAll();
    }

}