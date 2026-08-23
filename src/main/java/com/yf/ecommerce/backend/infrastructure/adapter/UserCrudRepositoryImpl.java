package com.yf.ecommerce.backend.infrastructure.adapter;

import com.yf.ecommerce.backend.domain.model.User;
import com.yf.ecommerce.backend.domain.port.IUserRepository;
import com.yf.ecommerce.backend.infrastructure.UserEntity;
import com.yf.ecommerce.backend.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/*
@Repository: clase que permite acceder a una BD.

Con esta clase, que hace parte del paquete de infraestructura, hacemos la conexion
con la capa de apliccaión y a su vez con el dominio.
 */
@Repository
public class UserCrudRepositoryImpl implements IUserRepository {

    private final IUserCrudRepository iUserCrudRepository;
    private final UserMapper userMapper;

    public UserCrudRepositoryImpl(IUserCrudRepository iUserCrudRepository, UserMapper userMapper) {
        this.iUserCrudRepository = iUserCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        // 1. Convertimos el objeto del negocio a una Entidad de Base de Datos
        UserEntity entityToSave = userMapper.toUserEntity(user);

        // 2. Guardamos la entidad en la base de datos. ".save" es de JPA.
        UserEntity savedEntity = iUserCrudRepository.save(entityToSave);

        // 3. Convertimos la entidad guardada de vuelta al formato del negocio
        return userMapper.toUser(savedEntity);

        //return userMapper.toUser(iUserCrudRepository.save(userMapper.toUserEntity(user)));
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        // 1. Buscamos el contenedor del usuario (Optional)
        Optional<UserEntity> entityOptional = iUserCrudRepository.findById(id);
        // 2. Verificamos si el usuario realmente existe en la base de datos
        if (entityOptional.isPresent()) {
            UserEntity userEntity = entityOptional.get();
            return userMapper.toUser(userEntity); // Convertimos y devolvemos
        }
        // 3. Si no existía, devolvemos null (o puedes lanzar un error)
        return null;

        //return userMapper.toUser(iUserCrudRepository.findById(id).get());
    }
}
