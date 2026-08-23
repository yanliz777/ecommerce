package com.yf.ecommerce.backend.infrastructure.adapter;

import com.yf.ecommerce.backend.infrastructure.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserCrudRepository extends CrudRepository<UserEntity,Integer> {

}
