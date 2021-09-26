package com.example.quattybackend.application.controller.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @NotBlank @NotNull @NotEmpty
    @Size(min = 3)
    private String street;

    private String complement;

    @NotEmpty @NotNull @NotBlank
    @Size(min = 8, max = 9)
    private String cep;
    @Valid
    private CityRequest cityRequest;
}
