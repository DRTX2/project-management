package com.projectManagement.heavySpring.adapters.rest.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// simplifica la creacion de clases de solo datos, estos son inmutables, evita codigo repetitivo y seguro para usar json con spring
public record UserRequest(
        @NotBlank String name,
        @Email String email,
        @Size(min=8) String password,
        String role
) {
}
