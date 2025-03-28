package com.projectManagement.heavySpring.adapters.rest.user;

import com.projectManagement.heavySpring.adapters.rest.user.dto.UserRequest;
import com.projectManagement.heavySpring.adapters.rest.user.dto.UserResponse;
import com.projectManagement.heavySpring.adapters.rest.user.mappers.UserRestMapper;
import com.projectManagement.heavySpring.core.models.User;
import com.projectManagement.heavySpring.core.usecases.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final UserRestMapper mapper;

    public UserController(UserService userService, UserRestMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request){
        User user= mapper.toDomain(request);
        return ResponseEntity.ok( mapper.toResponse(userService.createUser(user)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return userService.getUserById(id)
                .map(mapper::toResponse)// Convierte de User a UserResponse
                .map(ResponseEntity::ok) // si existe manda un ok
                .orElse(ResponseEntity.notFound().build());
    }

}
