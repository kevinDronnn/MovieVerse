package com.example.movieverse.mapper;

import com.example.movieverse.dto.CinemaLocationDto;
import com.example.movieverse.model.CinemaLocation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CinemaLocationMapper {

    CinemaLocationMapper INSTANCE = Mappers.getMapper(CinemaLocationMapper.class);

    @Mapping(source = "location", target = "location")
    List<CinemaLocationDto> CinemaLocationToCinemaLocationDto(List<CinemaLocation> cinemaLocations);

}
