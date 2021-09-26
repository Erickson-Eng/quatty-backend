package com.example.quattybackend.application.controller.dtos.mapper;

import com.example.quattybackend.application.controller.dtos.request.StateRequest;
import com.example.quattybackend.domain.entities.State;
import org.mapstruct.Mapper;

@Mapper
public interface StateMapper {

    State toEntity(StateRequest request);
}
