package org.example.movietickets.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.movietickets.dto.SeatReservationDto;
import org.example.movietickets.mapper.SeatReservationMapper;
import org.example.movietickets.model.MovieSchedule;
import org.example.movietickets.model.SeatReservation;
import org.example.movietickets.service.SeatReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = SeatReservationController.class, excludeAutoConfiguration = { SecurityAutoConfiguration.class })
@MockitoSettings(strictness = Strictness.LENIENT)
class SeatReservationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SeatReservationService seatReservationService;

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

    @DisplayName("Get reservations by schedule ID")
    @Test
    void getReservationsBySchedule_returnsSeatReservationDtoList() throws Exception {
        when(seatReservationService.getReservationsByScheduleId(1))
                .thenReturn(SeatReservationMapper.INSTANCE.seatReservationToSeatReservationDto(seatReservations));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/cinema/getBySchedule/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
        verify(seatReservationService, times(1)).getReservationsByScheduleId(1);
    }

    @DisplayName("Reserve seats")
    @Test
    void reserveSeat_returnsSeatReservationDtoList() throws Exception {
        ArgumentCaptor<List<SeatReservationDto>> captor = ArgumentCaptor.forClass(List.class);

        when(seatReservationService.reserveSeats(captor.capture()))
                .thenReturn(SeatReservationMapper.INSTANCE.seatReservationToSeatReservationDto(seatReservations));

        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/cinema/reserve")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(SeatReservationMapper.INSTANCE.seatReservationToSeatReservationDto(seatReservations)));

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andReturn();

        assertEquals(201, result.getResponse().getStatus());

        List<SeatReservationDto> capturedArgument = captor.getValue();
        assertEquals(seatReservations.size(), capturedArgument.size());
        assertEquals(seatReservations.get(0).getSeatRow(), capturedArgument.get(0).getSeatRow());
    }


    @DisplayName("Cancel reservation")
    @Test
    void cancelReservation_returnsNoContent() throws Exception {
        doNothing().when(seatReservationService).cancelReservation(1);

        RequestBuilder request = MockMvcRequestBuilders
                .delete("/api/cinema/cancel/1")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isNoContent())
                .andReturn();

        assertEquals(204, result.getResponse().getStatus());
        verify(seatReservationService, times(1)).cancelReservation(1);
    }


}