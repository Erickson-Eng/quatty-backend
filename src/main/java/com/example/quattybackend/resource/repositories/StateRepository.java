package com.example.quattybackend.resource.repositories;

import com.example.quattybackend.domain.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}