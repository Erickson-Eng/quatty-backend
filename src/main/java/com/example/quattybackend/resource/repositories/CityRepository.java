package com.example.quattybackend.resource.repositories;

import com.example.quattybackend.domain.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}