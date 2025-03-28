package com.projectManagement.heavySpring.adapters.persistence.user;

import com.projectManagement.heavySpring.core.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {
    // sirve para conversion automatica de objetos java. MapStruct genera código en tiempo de compilación para mapear objetos de un tipo a otro, eliminando la necesidad de escribir código repetitivo de conversión.
    // en este caso sera para User y UserEntity
    UserPersistenceMapper INSTANCE = Mappers.getMapper(UserPersistenceMapper.class);
    User toDomain(UserEntity entity);
    UserEntity toEntity(User domain);
}
