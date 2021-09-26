package com.example.quattybackend.application.controller.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateRequest {

    @NotBlank   @NotNull   @NotEmpty
    @Size(min = 3)
    private String stateName;


    @NotBlank   @NotNull   @NotEmpty
    @Size(min = 2, max = 2)
    private String uf;
}
