package com.example.movieverse.service;

import com.example.movieverse.dto.CinemaLocationDto;
import com.example.movieverse.mapper.CinemaLocationMapper;
import com.example.movieverse.repository.CinemaLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaLocationService {
    private final CinemaLocationRepository cinemaLocationRepository;

    public CinemaLocationService(CinemaLocationRepository cinemaLocationRepository) {
        this.cinemaLocationRepository = cinemaLocationRepository;
    }

    public List<CinemaLocationDto> findAll() {
        return CinemaLocationMapper.INSTANCE.CinemaLocationToCinemaLocationDto(cinemaLocationRepository.findAll());
    }
}
