package com.example.quattybackend.application.controller.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String cpf;
    private Double weight;
    private Double height;
    private String position;

    private AddressResponse addressResponse;
    private UserResponse userResponse;
}
