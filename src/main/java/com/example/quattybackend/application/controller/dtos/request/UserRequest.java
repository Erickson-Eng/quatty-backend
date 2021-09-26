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
public class UserRequest {

    @NotNull @NotEmpty @NotBlank
    @Size(min = 4, max = 20)
    private String username;
    @NotNull @NotEmpty @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    private String authorization;
}
