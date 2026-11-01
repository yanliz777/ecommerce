package com.yf.ecommerce.backend.infrastructure.mapper;

import com.yf.ecommerce.backend.domain.model.User;
import com.yf.ecommerce.backend.infrastructure.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//para que el contenedor spring proporcione una intancia si l aquiero usar en otra clase
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings(
            {
                /*
                source = fuente (userEntity)
                target = objetivo (User)
                 */
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "username", target = "username"),
                    @Mapping(source = "firstname", target = "firstname"),
                    @Mapping(source = "lastname", target = "lastname"),
                    @Mapping(source = "email", target = "email"),
                    @Mapping(source = "addres", target = "addres"),
                    @Mapping(source = "cellphone", target = "cellphone"),
                    @Mapping(source = "password", target = "password"),
                    @Mapping(source = "userType", target = "userType"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "dateUpdated", target = "dateUpdated")
            }
    )
    /*
    Convierte una entidad(UserEntity) a
    un objeto User.
     */
    User toUser(UserEntity userEntity);
    Iterable<User> toUsers(Iterable<UserEntity> userEntities);

    /*
   Converte una entidad(User) a
   un objeto UserEntity.
    */
    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);
}
