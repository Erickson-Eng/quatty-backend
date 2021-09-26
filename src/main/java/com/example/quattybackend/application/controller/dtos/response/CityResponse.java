package com.example.quattybackend.application.controller.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityResponse {

    private Integer id;
    private String cityName;
    private StateResponse stateResponse;
}
