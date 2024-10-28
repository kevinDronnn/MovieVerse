package org.example.movietickets.mapper;

import org.example.movietickets.dto.ScreeningDto;
import org.example.movietickets.model.Screening;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ScreeningMapper {
    ScreeningMapper INSTANCE = Mappers.getMapper(ScreeningMapper.class);

    @Mapping(source = "movie.id", target = "movieId")
    @Mapping(source = "movie.title", target = "movieTitle")
    @Mapping(source = "cinemaLocation.id", target = "cinemaLocationId")
    @Mapping(source = "cinemaLocation.location", target = "cinemaLocationName")
    ScreeningDto screeningToScreeningDto(Screening screening);

    @Mapping(source = "movieId", target = "movie.id")
    @Mapping(source = "cinemaLocationId", target = "cinemaLocation.id")
    Screening screeningDtoToScreening(ScreeningDto screeningDto);
}