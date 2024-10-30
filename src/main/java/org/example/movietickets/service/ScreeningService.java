package org.example.movietickets.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.movietickets.dto.ScreeningDto;
import org.example.movietickets.mapper.ScreeningMapper;
import org.example.movietickets.model.Screening;
import org.example.movietickets.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Service for screenings
 * @author Artem Voroshylin
 * @version 1.1
 * @since 1.1
 */
@Service
public class ScreeningService {

    @Autowired
    ScreeningRepository screeningRepository;

    /**
     * Method for saving mapped screening
     * @param screening that we get from request
     * @return mapped screening dto
     * @see ScreeningMapper
     */
    @Transactional
    public ScreeningDto save(Screening screening) {
        return ScreeningMapper.INSTANCE.screeningToScreeningDto(screeningRepository.save(screening));
    }

    /**
     * Method for updating mapped screening after checking of existing
     * @param screening new time and date
     * @param id of screening what we want to update
     * @return screening dto
     * @see ScreeningMapper
     */
    @Transactional
    public ScreeningDto update(Screening screening, int id) {
        Screening existingScreening = screeningRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Screening with id " + id + " not found"));

        existingScreening.setScreeningTime(screening.getScreeningTime());

        return ScreeningMapper.INSTANCE.screeningToScreeningDto(screeningRepository.save(existingScreening));
    }

    /**
     * Method return screening date for movie by it id and id of cinema
     * @param locationId of location what we need
     * @param movieId of movie what we need
     * @return mapped screening dto
     * @see ScreeningRepository
     * @see ScreeningMapper
     * @see EntityNotFoundException
     */
    public ScreeningDto findScreeningByLocationIdAndMovieId(int locationId, int movieId) {
        Screening existingScreening = screeningRepository.findByCinemaLocation_IdAndMovie_Id(locationId, movieId);
        if (existingScreening != null) {
            return ScreeningMapper.INSTANCE.screeningToScreeningDto(existingScreening);
        } else {
            throw new EntityNotFoundException("Screening not found for location ID " + locationId + " and movie ID " + movieId);
        }
    }

}
