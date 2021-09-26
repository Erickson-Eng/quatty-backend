package com.example.quattybackend.application.controller.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateResponse {

    private Integer id;
    private String stateName;
    private String uf;
}
