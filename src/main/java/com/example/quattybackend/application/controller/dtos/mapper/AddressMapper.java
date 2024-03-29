package com.example.quattybackend.application.controller.dtos.mapper;

import com.example.quattybackend.application.controller.dtos.request.AddressRequest;
import com.example.quattybackend.application.controller.dtos.response.AddressResponse;
import com.example.quattybackend.domain.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {CityMapper.class}, componentModel = "spring")
public interface AddressMapper {

    @Mappings({
            @Mapping(target = "city", source = "cityRequest")
    })
    Address toEntity(AddressRequest request);

    @Mappings({
            @Mapping(target = "cityResponse", source = "city")
    })
    AddressResponse toDTO(Address entity);
}
