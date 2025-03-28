package com.projectManagement.heavySpring.adapters.rest.user.dto;

import java.util.Date;

public record UserResponse(
        Long id,
        String name,
        String email,
        String role,
        Date registrationDate
) {
}
