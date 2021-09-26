package com.example.quattybackend.application.controller.dtos.mapper;

import com.example.quattybackend.application.controller.dtos.request.UserRequest;
import com.example.quattybackend.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User toEntity(UserRequest request);
}
