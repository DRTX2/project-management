package com.projectManagement.heavySpring.core.ports;

import com.projectManagement.heavySpring.core.models.User;

import java.util.Optional;

public interface UserRepository {
    public void save(User user);
    public Optional<User> findById(Long id);
}
