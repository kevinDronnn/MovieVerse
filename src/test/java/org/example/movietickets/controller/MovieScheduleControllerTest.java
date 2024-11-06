package org.example.movietickets.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.movietickets.dto.MovieScheduleDto;
import org.example.movietickets.mapper.MovieScheduleMapper;
import org.example.movietickets.model.CinemaLocation;
import org.example.movietickets.model.MovieCard;
import org.example.movietickets.model.MovieSchedule;
import org.example.movietickets.service.MovieScheduleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = MovieScheduleController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
class MovieScheduleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieScheduleService service;

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

    @DisplayName("get MovieSchedules")
    @Test
    void testGetMovieSchedule_returnsListMovieScheduleDto() throws Exception {
        when(service.getSchedulesByMovieIdAndLocationId(movieSchedule.getMovie().getId(), movieSchedule.getCinemaLocation().getId()))
                .thenReturn(MovieScheduleMapper.INSTANCE.movieScheduleToMovieScheduleDto(List.of(movieSchedule)));

        List<MovieScheduleDto> scheduleDtoList = service
                .getSchedulesByMovieIdAndLocationId(movieSchedule.getMovie().getId(), movieSchedule.getCinemaLocation().getId());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/cinema/getMovieSchedule/" + movieSchedule.getMovie().getId() + "/" + movieSchedule.getCinemaLocation().getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(scheduleDtoList));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @DisplayName("save MovieSchedule")
    @Test
    void testAddMovieSchedule_returnsMovieScheduleDto() throws Exception {
        when(service.saveSchedule(movieSchedule))
                .thenReturn(MovieScheduleMapper.INSTANCE.movieScheduleToMovieScheduleDto(movieSchedule));

        MovieScheduleDto movieScheduleDto = service.saveSchedule(movieSchedule);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/cinema/saveMovieSchedule")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(movieScheduleDto));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(201, result.getResponse().getStatus());
    }

    @DisplayName("update MovieSchedule")
    @Test
    void testUpdateMovieSchedule_returnsMovieScheduleDto() throws Exception {
        MovieScheduleDto movieScheduleDto = MovieScheduleMapper.INSTANCE.movieScheduleToMovieScheduleDto(movieSchedule);

        when(service.updateSchedule(movieSchedule))
                .thenReturn(MovieScheduleMapper.INSTANCE.movieScheduleToMovieScheduleDto(movieSchedule));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/cinema/updateMovieSchedule")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(movieScheduleDto));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }


    @DisplayName("delete MovieSchedule")
    @Test
    void testDeleteMovieSchedule_returnsNothing() throws Exception {
        doNothing().when(service).deleteSchedule(movieSchedule.getId());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/cinema/deleteMovieSchedule/" + movieSchedule.getMovie().getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        verify(service, times(1)).deleteSchedule(movieSchedule.getId());
    }


}