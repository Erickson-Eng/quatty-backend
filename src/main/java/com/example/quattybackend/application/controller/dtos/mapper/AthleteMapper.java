package com.example.quattybackend.application.controller.dtos.mapper;

import com.example.quattybackend.application.controller.dtos.request.AthleteRequest;
import com.example.quattybackend.domain.entities.Athlete;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {CityMapper.class, UserMapper.class})
public interface AthleteMapper {

    @Mappings({
            @Mapping(target = "address", source = "addressRequest"),
            @Mapping(target = "user", source = "userRequest"),
            @Mapping(target = "position", source = "position")
    })
    Athlete toEntity(AthleteRequest request);
}
