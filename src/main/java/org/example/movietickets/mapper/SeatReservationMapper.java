package org.example.movietickets.mapper;

import org.example.movietickets.dto.SeatReservationDto;
import org.example.movietickets.model.SeatReservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SeatReservationMapper {
    SeatReservationMapper INSTANCE = Mappers.getMapper(SeatReservationMapper.class);

    List<SeatReservationDto> seatReservationToSeatReservationDto(List<SeatReservation> seatReservation);
    List<SeatReservation> seatReservationDtoToSeatReservation(List<SeatReservationDto> seatReservationDto);
}
