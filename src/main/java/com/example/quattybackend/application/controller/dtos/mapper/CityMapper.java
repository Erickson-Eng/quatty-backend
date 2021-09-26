package com.example.quattybackend.application.controller.dtos.mapper;

import com.example.quattybackend.application.controller.dtos.request.CityRequest;
import com.example.quattybackend.application.controller.dtos.response.CityResponse;
import com.example.quattybackend.domain.entities.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {StateMapper.class}, componentModel = "spring")
public interface CityMapper {

    @Mapping(target = "state", source = "stateRequest")
    City toEntity(CityRequest request);

    @Mapping(target = "stateResponse", source = "state")
    CityResponse toDTO(City entity);
}
