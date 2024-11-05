package org.example.movietickets.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.movietickets.dto.MovieScheduleDto;
import org.example.movietickets.mapper.MovieScheduleMapper;
import org.example.movietickets.model.MovieSchedule;
import org.example.movietickets.repository.MovieScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieScheduleService {
    @Autowired
    MovieScheduleRepository movieScheduleRepository;

    public List<MovieScheduleDto> getSchedulesByMovieIdAndLocationId(int movieId, int locationId) {
        List<MovieSchedule> movieScheduleList = movieScheduleRepository.findByMovieIdAndCinemaLocationId(movieId, locationId);

        if (movieScheduleList.isEmpty()) {
            throw new EntityNotFoundException("Schedule with movieId= " + movieId + " and locationId= "+locationId+" not found");
        }

        return MovieScheduleMapper.INSTANCE.movieScheduleToMovieScheduleDto(movieScheduleList);
    }

    public MovieScheduleDto saveSchedule(MovieSchedule movieSchedule) {
        return MovieScheduleMapper
                .INSTANCE
                .movieScheduleToMovieScheduleDto(movieScheduleRepository.save(movieSchedule));
    }

    public MovieScheduleDto updateSchedule(MovieSchedule movieSchedule) {
        MovieSchedule movieScheduleEntity = movieScheduleRepository
                .findById(movieSchedule.getId())
                .orElseThrow(() -> new EntityNotFoundException("Schedule with id= " + movieSchedule.getId() + " not found"));
        movieScheduleEntity.setScreeningTime(movieSchedule.getScreeningTime());

        return MovieScheduleMapper.INSTANCE.movieScheduleToMovieScheduleDto(movieScheduleRepository.save(movieScheduleEntity));
    }

    public void deleteSchedule(int id) {
        MovieSchedule schedule = movieScheduleRepository.findById(id).get();
        if (schedule != null) {
            movieScheduleRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Schedule with id = " + id + " not found");
        }
    }

}