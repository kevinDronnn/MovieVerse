package org.example.movietickets.service;

import org.example.movietickets.dto.SeatReservationDto;
import org.example.movietickets.mapper.SeatReservationMapper;
import org.example.movietickets.model.MovieSchedule;
import org.example.movietickets.model.SeatReservation;
import org.example.movietickets.repository.SeatReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SeatReservationServiceTest {

    @InjectMocks
    SeatReservationService service;

    @Mock
    SeatReservationRepository repository;

    List<SeatReservation> seatReservations;

    SeatReservation seatReservation;

    @BeforeEach
    void setUp() {
        seatReservation = new SeatReservation();
        seatReservation.setId(1);
        seatReservation.setMovieSchedule(new MovieSchedule());
        seatReservation.getMovieSchedule().setId(1);
        seatReservation.setSeatRow(5);
        seatReservation.setSeatNumber(10);
        seatReservation.setReserved(true);
        seatReservation.setReservationTime(new Timestamp(System.currentTimeMillis()));
        seatReservations = new ArrayList<>();
        seatReservations.add(seatReservation);
    }

    @Test
    void testReserveSeats_returnsSeatReservationDtoList() {
        doReturn(seatReservations).when(repository).saveAll(anyList());

        List<SeatReservationDto> result = service.reserveSeats(SeatReservationMapper.INSTANCE.seatReservationToSeatReservationDto(seatReservations));

        assertEquals(seatReservation.getId(), result.get(0).getId());
        assertEquals(seatReservation.getSeatRow(), result.get(0).getSeatRow());
        assertEquals(seatReservation.getSeatNumber(), result.get(0).getSeatNumber());
        assertTrue(result.get(0).isReserved());

        verify(repository, times(1)).saveAll(anyList());
    }

    @Test
    void testCancelReservation() {
        when(repository.findById(seatReservation.getId())).thenReturn(Optional.of(seatReservation));

        service.cancelReservation(seatReservation.getId());

        verify(repository, times(1)).delete(seatReservation);
    }
}
