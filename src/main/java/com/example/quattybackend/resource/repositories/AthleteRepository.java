package com.example.quattybackend.resource.repositories;

import com.example.quattybackend.domain.entities.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
}