package com.yf.ecommerce.backend.infrastructure.adapter.interfaces;

import com.yf.ecommerce.backend.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserCrudRepository extends CrudRepository<UserEntity,Integer> {

}
