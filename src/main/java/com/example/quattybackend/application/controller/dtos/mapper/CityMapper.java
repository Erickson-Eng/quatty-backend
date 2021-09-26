package com.example.quattybackend.application.controller.dtos.mapper;

import com.example.quattybackend.application.controller.dtos.request.CityRequest;
import com.example.quattybackend.domain.entities.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {StateMapper.class})
public interface CityMapper {

    @Mapping(target = "state", source = "stateRequest")
    City toEntity(CityRequest request);
}
