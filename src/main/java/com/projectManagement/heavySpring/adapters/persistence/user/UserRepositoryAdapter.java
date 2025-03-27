package com.projectManagement.heavySpring.adapters.persistence.user;

import com.projectManagement.heavySpring.core.models.User;
import com.projectManagement.heavySpring.core.ports.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class UserRepositoryAdapter implements UserRepository {

    private final UserPersistenceImpl persistenceRepository;
    // MapStruct genera el código de mapeo entre objetos, como lo harías usando DTOs, pero de manera automática y eficiente.
    private final UserMapper userMapper;

    public UserRepositoryAdapter(UserPersistenceImpl persistenceRepository, UserMapper userMapper) {
        this.persistenceRepository = persistenceRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void save(User user) {
        UserEntity entity= userMapper.toEntity(user);
        persistenceRepository.save(entity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return persistenceRepository.findById(id).map(userMapper::toDomain);
    }
}
