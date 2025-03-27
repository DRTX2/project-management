package com.projectManagement.heavySpring.adapters.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPersistenceImpl extends JpaRepository<UserEntity,Long> {
}
