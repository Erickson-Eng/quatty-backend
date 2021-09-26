package com.example.quattybackend.application.controller.dtos.mapper;

import com.example.quattybackend.application.controller.dtos.request.StateRequest;
import com.example.quattybackend.application.controller.dtos.response.StateResponse;
import com.example.quattybackend.domain.entities.State;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StateMapper {

    State toEntity(StateRequest request);

    StateResponse toDTO(State entity);
}
