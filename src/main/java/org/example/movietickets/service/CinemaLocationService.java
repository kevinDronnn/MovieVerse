package org.example.movietickets.service;

import org.example.movietickets.dto.CinemaLocationDto;
import org.example.movietickets.mapper.CinemaLocationMapper;
import org.example.movietickets.repository.CinemaLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaLocationService {

    @Autowired
    private CinemaLocationRepository cinemaLocationRepository;

    public List<CinemaLocationDto> findAll() {
        return CinemaLocationMapper.INSTANCE.cinemaLocationToCinemaLocationDto(cinemaLocationRepository.findAll());
    }
}
