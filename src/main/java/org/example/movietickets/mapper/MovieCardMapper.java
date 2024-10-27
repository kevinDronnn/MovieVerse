package org.example.movietickets.mapper;


import org.example.movietickets.dto.MovieCardDto;
import org.example.movietickets.model.MovieCard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovieCardMapper {

    MovieCardMapper INSTANCE = Mappers.getMapper(MovieCardMapper.class);

    List<MovieCardDto> toMovieCardDtoList(List<MovieCard> movieCards);

    MovieCard toMovieCard(MovieCardDto movieCardDto);

    MovieCardDto toMovieCardDto(MovieCard movieCard);
}
