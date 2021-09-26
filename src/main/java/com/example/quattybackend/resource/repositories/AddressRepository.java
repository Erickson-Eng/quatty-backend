package com.example.quattybackend.resource.repositories;

import com.example.quattybackend.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}