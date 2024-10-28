package org.example.movietickets.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.movietickets.dto.CinemaLocationDto;
import org.example.movietickets.service.CinemaLocationService;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = CinemaLocationController.class, excludeAutoConfiguration = { SecurityAutoConfiguration.class })
class CinemaLocationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CinemaLocationService service;

    @DisplayName("get all locations of cinemas")
    @Test
    void testFindAll_returnsListOfCinemas() throws Exception {
        CinemaLocationDto cinemaLocation = new CinemaLocationDto("test location");
        when(service.findAll()).thenReturn(List.of(cinemaLocation));

        List<CinemaLocationDto> cinemaLocationDtoList = service.findAll();

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/cinema/location")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(cinemaLocationDtoList));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

}