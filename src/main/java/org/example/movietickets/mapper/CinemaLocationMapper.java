package org.example.movietickets.mapper;


import org.example.movietickets.dto.CinemaLocationDto;
import org.example.movietickets.model.CinemaLocation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CinemaLocationMapper {

    CinemaLocationMapper INSTANCE = Mappers.getMapper(CinemaLocationMapper.class);

    List<CinemaLocationDto> cinemaLocationToCinemaLocationDto(List<CinemaLocation> cinemaLocations);
}

