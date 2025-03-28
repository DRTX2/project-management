package com.projectManagement.heavySpring.core.usecases;

import com.projectManagement.heavySpring.core.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserById(Long id);
//    List<User> getAllUsers();
//    User updateUser(User user);
//    void deleteUser(Long id);
}
