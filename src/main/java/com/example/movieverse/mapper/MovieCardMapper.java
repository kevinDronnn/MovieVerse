package com.example.movieverse.mapper;

import com.example.movieverse.dto.MovieCardDto;
import com.example.movieverse.model.MovieCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovieCardMapper {

    MovieCardMapper INSTANCE = Mappers.getMapper(MovieCardMapper.class);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "year", target = "year")
    @Mapping(source = "director", target = "director")
    @Mapping(source = "distributionPeriod", target = "distributionPeriod")
    @Mapping(source = "moviegoerRating", target = "moviegoerRating")
    @Mapping(source = "criticsRating", target = "criticsRating")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "production", target = "production")
    @Mapping(source = "studio", target = "studio")
    @Mapping(source = "screenplay", target = "screenplay")
    @Mapping(source = "starring", target = "starring")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "trailerIframeLink", target = "trailerIframeLink")
    List<MovieCardDto> MovieCardToMovieCardDto(List<MovieCard> movieCard);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "year", target = "year")
    @Mapping(source = "director", target = "director")
    @Mapping(source = "distributionPeriod", target = "distributionPeriod")
    @Mapping(source = "moviegoerRating", target = "moviegoerRating")
    @Mapping(source = "criticsRating", target = "criticsRating")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "production", target = "production")
    @Mapping(source = "studio", target = "studio")
    @Mapping(source = "screenplay", target = "screenplay")
    @Mapping(source = "starring", target = "starring")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "trailerIframeLink", target = "trailerIframeLink")
    MovieCard MovieCardDtoToMovieCard(MovieCardDto movieCardDto);


}
