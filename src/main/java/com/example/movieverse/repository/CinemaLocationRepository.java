package com.example.movieverse.repository;

import com.example.movieverse.model.CinemaLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaLocationRepository extends JpaRepository<CinemaLocation, Integer> {
    List<CinemaLocation> findAll();
}
