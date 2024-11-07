package org.example.movietickets.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.movietickets.dto.ScreeningDto;
import org.example.movietickets.mapper.ScreeningMapper;
import org.example.movietickets.model.CinemaLocation;
import org.example.movietickets.model.MovieCard;
import org.example.movietickets.model.Screening;
import org.example.movietickets.service.ScreeningService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ScreeningController.class, excludeAutoConfiguration = { SecurityAutoConfiguration.class })
class ScreeningControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScreeningService screeningService;

    Screening screening;

    @BeforeEach
    void setUp() {
        screening = new Screening();
        screening.setId(1);
        screening.setMovie(new MovieCard());
        screening.getMovie().setId(1);
        screening.setCinemaLocation(new CinemaLocation());
        screening.getCinemaLocation().setId(1);
        screening.setEndDate(new Timestamp(System.currentTimeMillis()));
    }

    @DisplayName("get screening")
    @Test
    void findScreeningByLocationIdAndMovieId_returnsScreeningDto() throws Exception {
        when(screeningService.findScreeningByLocationIdAndMovieId(screening.getCinemaLocation().getId(),screening.getMovie().getId())).thenReturn(ScreeningMapper.INSTANCE.screeningToScreeningDto(screening));

        ScreeningDto screeningDto = screeningService.findScreeningByLocationIdAndMovieId(screening.getCinemaLocation().getId(),screening.getMovie().getId());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/cinema/getScreening/"+screening.getCinemaLocation().getId()+"/"+screening.getMovie().getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(screeningDto));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @DisplayName("save screening")
    @Test
    void testSave_returnsScreeningDto() throws Exception {
        when(screeningService.save(screening)).thenReturn(ScreeningMapper.INSTANCE.screeningToScreeningDto(screening));

        ScreeningDto screeningDto = screeningService.save(screening);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/cinema/saveScreening")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(screeningDto));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(201, result.getResponse().getStatus());
    }

    @DisplayName("update screening")
    @Test
    void testUpdate_returnsScreeningDto() throws Exception {
        when(screeningService.update(screening,screening.getId())).thenReturn(ScreeningMapper.INSTANCE.screeningToScreeningDto(screening));

        ScreeningDto screeningDto = ScreeningMapper.INSTANCE.screeningToScreeningDto(screening);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/cinema/updateScreening/"+screening.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(screeningDto));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @DisplayName("delete Screening")
    @Test
    void testDeleteScreening_returnsNothing() throws Exception {
        doNothing().when(screeningService).deleteScreening(screening.getId());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/cinema/deleteScreening/" + screening.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        verify(screeningService, times(1)).deleteScreening(screening.getId());
    }

}