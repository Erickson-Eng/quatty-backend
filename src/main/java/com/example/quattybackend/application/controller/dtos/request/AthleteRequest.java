package com.example.quattybackend.application.controller.dtos.request;

import com.example.quattybackend.domain.entities.enums.BasketballPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteRequest {

    @NotBlank @NotNull @NotEmpty
    @Size(min = 3, max = 15)
    private String firstName;
    @NotBlank @NotNull @NotEmpty
    @Size(min = 3, max = 50)
    private String lastName;
    @CPF @NotNull @NotBlank
    private String cpf;

    private Double weight;
    private Double height;
    private Integer position;

    @Valid
    private AddressRequest addressRequest;
    @Valid
    private UserRequest userRequest;

}
