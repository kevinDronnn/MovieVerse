package org.example.movietickets.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.movietickets.dto.SeatReservationDto;
import org.example.movietickets.mapper.SeatReservationMapper;
import org.example.movietickets.model.SeatReservation;
import org.example.movietickets.repository.SeatReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SeatReservationService {
    @Autowired
    private SeatReservationRepository seatReservationRepository;

    public List<SeatReservationDto> getReservationsByScheduleId(int movieScheduleId) {
        List<SeatReservation> reservations = seatReservationRepository.findByMovieScheduleId(movieScheduleId);
        return SeatReservationMapper.INSTANCE.seatReservationToSeatReservationDto(reservations);
    }

    public List<SeatReservationDto> reserveSeats(List<SeatReservationDto> seatReservationDtoList) {
        List<SeatReservation> seatReservations = SeatReservationMapper.INSTANCE.seatReservationDtoToSeatReservation(seatReservationDtoList);

        seatReservations.forEach(seat -> {
            seat.setReserved(true);
            seat.setReservationTime(new Timestamp(System.currentTimeMillis()));
        });

        List<SeatReservation> savedReservations = seatReservationRepository.saveAll(seatReservations);
        return SeatReservationMapper.INSTANCE.seatReservationToSeatReservationDto(savedReservations);
    }


    public void cancelReservation(int id) {
        SeatReservation reservation = seatReservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));
        seatReservationRepository.delete(reservation);
    }
}
