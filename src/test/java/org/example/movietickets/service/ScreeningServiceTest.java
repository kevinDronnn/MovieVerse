package org.example.movietickets.service;

import org.example.movietickets.dto.ScreeningDto;
import org.example.movietickets.model.CinemaLocation;
import org.example.movietickets.model.MovieCard;
import org.example.movietickets.model.Screening;
import org.example.movietickets.repository.ScreeningRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ScreeningServiceTest {

    @InjectMocks
    ScreeningService screeningService;

    @Mock
    ScreeningRepository screeningRepository;

    Screening screening;

    @BeforeEach
    void setUp() {
        screening = new Screening();
        screening.setId(1);
        screening.setMovie(new MovieCard());
        screening.getMovie().setId(1);
        screening.getMovie().setTitle("Inception");
        screening.setCinemaLocation(new CinemaLocation());
        screening.getCinemaLocation().setId(1);
        screening.getCinemaLocation().setLocation("Kyiv");
        screening.setEndDate(new Timestamp(System.currentTimeMillis()));
        screening.setStartDate(new Timestamp(System.currentTimeMillis()));
    }

    @DisplayName("get screening")
    @Test
    void testFindScreeningByLocationIdAndMovieId_returnsScreeningDto() {
        when(screeningRepository.findByCinemaLocation_IdAndMovie_Id(screening.getCinemaLocation().getId(),screening.getMovie().getId())).thenReturn(screening);

        ScreeningDto result = screeningService.findScreeningByLocationIdAndMovieId(screening.getCinemaLocation().getId(),screening.getMovie().getId());

        assertEquals(screening.getId(), result.getId());
        assertEquals(screening.getMovie().getTitle(), result.getMovieTitle());
        assertEquals(screening.getMovie().getId(), result.getMovieId());
        assertEquals(screening.getCinemaLocation().getId(), result.getCinemaLocationId());
        assertEquals(screening.getCinemaLocation().getLocation(), result.getCinemaLocationName());
        assertEquals(screening.getEndDate(), result.getEndDate());
        assertEquals(screening.getStartDate(), result.getStartDate());

        verify(screeningRepository, times(1)).findByCinemaLocation_IdAndMovie_Id(screening.getCinemaLocation().getId(),screening.getMovie().getId());
    }

    @DisplayName("save screening")
    @Test
    void testSave_returnsScreeningDto() {
        when(screeningRepository.save(screening)).thenReturn(screening);

        ScreeningDto result = screeningService.save(screening);

        assertEquals(screening.getId(), result.getId());
        assertEquals(screening.getMovie().getTitle(), result.getMovieTitle());
        assertEquals(screening.getMovie().getId(), result.getMovieId());
        assertEquals(screening.getCinemaLocation().getId(), result.getCinemaLocationId());
        assertEquals(screening.getCinemaLocation().getLocation(), result.getCinemaLocationName());
        assertEquals(screening.getEndDate(), result.getEndDate());
        assertEquals(screening.getStartDate(), result.getStartDate());

        verify(screeningRepository, times(1)).save(screening);
    }

    @DisplayName("update screening")
    @Test
    void testUpdate_returnsScreeningDto() {
        when(screeningRepository.findById(screening.getId())).thenReturn(Optional.of(screening));
        when(screeningRepository.save(screening)).thenReturn(screening);

        ScreeningDto result = screeningService.update(screening, screening.getId());

        assertEquals(screening.getId(), result.getId());
        assertEquals(screening.getMovie().getTitle(), result.getMovieTitle());
        assertEquals(screening.getMovie().getId(), result.getMovieId());
        assertEquals(screening.getCinemaLocation().getId(), result.getCinemaLocationId());
        assertEquals(screening.getCinemaLocation().getLocation(), result.getCinemaLocationName());
        assertEquals(screening.getEndDate(), result.getEndDate());
        assertEquals(screening.getStartDate(), result.getStartDate());

        verify(screeningRepository, times(1)).save(screening);
        verify(screeningRepository, times(1)).findById(screening.getId());
    }

}