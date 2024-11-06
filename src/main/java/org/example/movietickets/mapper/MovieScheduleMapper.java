package org.example.movietickets.mapper;

import org.example.movietickets.dto.MovieScheduleDto;
import org.example.movietickets.model.MovieSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovieScheduleMapper {
    MovieScheduleMapper INSTANCE = Mappers.getMapper(MovieScheduleMapper.class);

    @Mapping(source = "movie.id", target = "movieId")
    @Mapping(source = "cinemaLocation.id", target = "cinemaLocationId")
    MovieScheduleDto movieScheduleToMovieScheduleDto(MovieSchedule movieSchedule);

    List<MovieScheduleDto> movieScheduleToMovieScheduleDto(List<MovieSchedule> movieScheduleList);

    @Mapping(source = "movieId", target = "movie.id")
    @Mapping(source = "cinemaLocationId", target = "cinemaLocation.id")
    MovieSchedule movieScheduleDtoToMovieSchedule(MovieScheduleDto movieScheduleDto);
}
