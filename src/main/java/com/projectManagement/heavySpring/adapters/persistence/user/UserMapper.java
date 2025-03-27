package com.projectManagement.heavySpring.adapters.persistence.user;

import com.projectManagement.heavySpring.core.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    // sirve para conversion automatica de objetos java. MapStruct genera código en tiempo de compilación para mapear objetos de un tipo a otro, eliminando la necesidad de escribir código repetitivo de conversión.
    // en este caso sera para User y UserEntity
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toDomain(UserEntity entity);
    UserEntity toEntity(User domain);
}
