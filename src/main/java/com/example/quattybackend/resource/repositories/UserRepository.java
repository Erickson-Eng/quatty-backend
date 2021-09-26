package com.example.quattybackend.resource.repositories;

import com.example.quattybackend.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}