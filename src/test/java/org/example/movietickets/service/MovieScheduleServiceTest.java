package org.example.movietickets.service;

import org.example.movietickets.dto.MovieScheduleDto;
import org.example.movietickets.model.CinemaLocation;
import org.example.movietickets.model.MovieCard;
import org.example.movietickets.model.MovieSchedule;
import org.example.movietickets.repository.MovieScheduleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieScheduleServiceTest {

    @InjectMocks
    MovieScheduleService service;

    @Mock
    MovieScheduleRepository repository;

    MovieSchedule movieSchedule;

    @BeforeEach
    void setUp() {
        movieSchedule = new MovieSchedule();
        movieSchedule.setId(1);
        movieSchedule.setMovie(new MovieCard());
        movieSchedule.getMovie().setId(1);
        movieSchedule.setCinemaLocation(new CinemaLocation());
        movieSchedule.getCinemaLocation().setId(1);
        movieSchedule.setScreeningTime(new Timestamp(System.currentTimeMillis()));
    }

    @DisplayName("get movie schedule by movie and location")
    @Test
    void testGetSchedulesByMovieIdAndLocationId_returnsMovieScheduleDtoList() {
        when(repository.findByMovieIdAndCinemaLocationId(1, 1)).thenReturn(List.of(movieSchedule));

        List<MovieScheduleDto> result = service.getSchedulesByMovieIdAndLocationId(1, 1);

        assertEquals(1, result.size());
        MovieScheduleDto dto = result.get(0);
        assertEquals(movieSchedule.getId(), dto.getId());
        assertEquals(movieSchedule.getMovie().getId(), dto.getMovieId());
        assertEquals(movieSchedule.getCinemaLocation().getId(), dto.getCinemaLocationId());
        assertEquals(movieSchedule.getScreeningTime(), dto.getScreeningTime());

        verify(repository, times(1)).findByMovieIdAndCinemaLocationId(1, 1);
    }

    @DisplayName("save movie schedule")
    @Test
    void testSaveSchedule_returnsMovieScheduleDto() {
        when(repository.save(movieSchedule)).thenReturn(movieSchedule);

        MovieScheduleDto result = service.saveSchedule(movieSchedule);

        assertEquals(movieSchedule.getId(), result.getId());
        assertEquals(movieSchedule.getMovie().getId(), result.getMovieId());
        assertEquals(movieSchedule.getCinemaLocation().getId(), result.getCinemaLocationId());
        assertEquals(movieSchedule.getScreeningTime(), result.getScreeningTime());

        verify(repository, times(1)).save(movieSchedule);
    }

    @DisplayName("update movie schedule")
    @Test
    void testUpdateSchedule_returnsUpdatedMovieScheduleDto() {
        when(repository.findById(movieSchedule.getId())).thenReturn(Optional.of(movieSchedule));
        when(repository.save(movieSchedule)).thenReturn(movieSchedule);

        MovieScheduleDto result = service.updateSchedule(movieSchedule);

        assertEquals(movieSchedule.getId(), result.getId());
        assertEquals(movieSchedule.getMovie().getId(), result.getMovieId());
        assertEquals(movieSchedule.getCinemaLocation().getId(), result.getCinemaLocationId());
        assertEquals(movieSchedule.getScreeningTime(), result.getScreeningTime());

        verify(repository, times(1)).findById(movieSchedule.getId());
        verify(repository, times(1)).save(movieSchedule);
    }

    @DisplayName("delete movie schedule")
    @Test
    void testDeleteSchedule() {
        when(repository.findById(movieSchedule.getId())).thenReturn(Optional.of(movieSchedule));

        service.deleteSchedule(movieSchedule.getId());

        verify(repository, times(1)).deleteById(movieSchedule.getId());
    }

}