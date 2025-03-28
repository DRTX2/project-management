package com.projectManagement.heavySpring.adapters.services;

import com.projectManagement.heavySpring.adapters.persistence.user.UserPersistenceImpl;
import com.projectManagement.heavySpring.core.models.User;
import com.projectManagement.heavySpring.core.ports.UserRepository;
import com.projectManagement.heavySpring.core.usecases.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        user.validate();
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }
}
