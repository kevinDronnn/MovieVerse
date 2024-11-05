package org.example.movietickets.mapper;

import org.example.movietickets.dto.MovieScheduleDto;
import org.example.movietickets.model.MovieSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovieScheduleMapper {
    MovieScheduleMapper INSTANCE = Mappers.getMapper(MovieScheduleMapper.class);

    List<MovieScheduleDto> movieScheduleToMovieScheduleDto(List<MovieSchedule> movieSchedule);

    MovieScheduleDto movieScheduleToMovieScheduleDto(MovieSchedule movieSchedule);

    MovieSchedule movieScheduleDtoToMovieSchedule(MovieScheduleDto movieScheduleDto);
}
