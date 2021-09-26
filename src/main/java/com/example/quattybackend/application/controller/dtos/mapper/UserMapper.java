package com.example.quattybackend.application.controller.dtos.mapper;

import com.example.quattybackend.application.controller.dtos.request.UserRequest;
import com.example.quattybackend.application.controller.dtos.response.UserResponse;
import com.example.quattybackend.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequest request);

    UserResponse toDTO(User entity);
}
