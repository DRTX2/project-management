package com.projectManagement.heavySpring.adapters.persistence.user;

import com.projectManagement.heavySpring.core.models.User;
import com.projectManagement.heavySpring.core.ports.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserRepositoryAdapter implements UserRepository {

    private final UserPersistenceRepository persistenceRepository;
    // MapStruct genera el código de mapeo entre objetos, como lo harías usando DTOs, pero de manera automática y eficiente.
    private final UserPersistenceMapper userPersistenceMapper;

    public UserRepositoryAdapter(UserPersistenceRepository persistenceRepository, UserPersistenceMapper userPersistenceMapper) {
        this.persistenceRepository = persistenceRepository;
        this.userPersistenceMapper = userPersistenceMapper;
    }

    @Override
    public User save(User user) {
        UserEntity entity= userPersistenceMapper.toEntity(user);
        UserEntity savedEntity=persistenceRepository.save(entity);
        return userPersistenceMapper.toDomain(savedEntity);// carga el id
    }

    @Override
    public Optional<User> findById(Long id) {
        return persistenceRepository.findById(id).map(userPersistenceMapper::toDomain);
    }
}
