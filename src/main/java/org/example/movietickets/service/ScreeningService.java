package org.example.movietickets.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.movietickets.dto.ScreeningDto;
import org.example.movietickets.mapper.ScreeningMapper;
import org.example.movietickets.model.Screening;
import org.example.movietickets.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreeningService {

    @Autowired
    ScreeningRepository screeningRepository;

    @Transactional
    public ScreeningDto save(Screening screening) {
        return ScreeningMapper.INSTANCE.screeningToScreeningDto(screeningRepository.save(screening));
    }

    @Transactional
    public ScreeningDto update(Screening screening, int id) {
        Screening existingScreening = screeningRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Screening with id " + id + " not found"));

        existingScreening.setScreeningTime(screening.getScreeningTime());

        return ScreeningMapper.INSTANCE.screeningToScreeningDto(screeningRepository.save(existingScreening));
    }

    public ScreeningDto findScreeningByLocationIdAndMovieId(int locationId, int movieId) {
        Screening existingScreening = screeningRepository.findByCinemaLocation_IdAndMovie_Id(locationId, movieId);
        if (existingScreening != null) {
            return ScreeningMapper.INSTANCE.screeningToScreeningDto(existingScreening);
        } else {
            throw new EntityNotFoundException("Screening not found for location ID " + locationId + " and movie ID " + movieId);
        }
    }

}
