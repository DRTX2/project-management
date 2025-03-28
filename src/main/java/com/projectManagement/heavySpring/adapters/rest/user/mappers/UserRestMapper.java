package com.projectManagement.heavySpring.adapters.rest.user.mappers;

import com.projectManagement.heavySpring.adapters.rest.user.dto.UserRequest;
import com.projectManagement.heavySpring.adapters.rest.user.dto.UserResponse;
import com.projectManagement.heavySpring.core.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRestMapper {
    User toDomain(UserRequest request);
    UserResponse toResponse(User user);
}
