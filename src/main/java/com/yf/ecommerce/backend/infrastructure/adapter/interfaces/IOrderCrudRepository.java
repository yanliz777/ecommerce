package com.yf.ecommerce.backend.infrastructure.adapter.interfaces;

import com.yf.ecommerce.backend.domain.model.OrderState;
import com.yf.ecommerce.backend.infrastructure.entity.OrderEntity;
import com.yf.ecommerce.backend.infrastructure.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IOrderCrudRepository extends CrudRepository<OrderEntity, Integer> {
    //Actualizar el estado de una orde por id: query métodos
    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.orderState = :state  WHERE o.id = :id ")
    void updateStateById(Integer id, OrderState state);

    Iterable<OrderEntity> findByUserEntity(UserEntity userEntity);

}
