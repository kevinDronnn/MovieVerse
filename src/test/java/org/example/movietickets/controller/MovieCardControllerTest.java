package org.example.movietickets.controller;

import org.example.movietickets.dto.MovieCardDto;
import org.example.movietickets.service.MovieCardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
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
@WebMvcTest(controllers = MovieCardController.class, excludeAutoConfiguration = { SecurityAutoConfiguration.class })
class MovieCardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieCardService movieCardService;

    @DisplayName("get all movies by location")
    @ParameterizedTest
    @ValueSource(strings = {"Odesa", "Kyiv", "Lviv"})
    void testGetAllMoviesByLocation_returnsListOfMovies(String location) throws Exception {
        MovieCardDto movieCardDto = new MovieCardDto();
        when(movieCardService.findMoviesByLocation(location)).thenReturn(List.of(movieCardDto));

        RequestBuilder builder = MockMvcRequestBuilders
                .get("/api/cinema/movies")
                .param("location", location)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(builder).andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertNotNull(result.getResponse().getContentAsString(), "Expected non-null response content");
    }
}
