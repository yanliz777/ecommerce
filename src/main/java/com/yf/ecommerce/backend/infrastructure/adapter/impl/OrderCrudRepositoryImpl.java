package com.yf.ecommerce.backend.infrastructure.adapter.impl;

import com.yf.ecommerce.backend.domain.model.Order;
import com.yf.ecommerce.backend.domain.model.OrderState;
import com.yf.ecommerce.backend.domain.port.IOrderRepository;
import com.yf.ecommerce.backend.infrastructure.adapter.interfaces.IOrderCrudRepository;
import com.yf.ecommerce.backend.infrastructure.entity.OrderEntity;
import com.yf.ecommerce.backend.infrastructure.entity.UserEntity;
import com.yf.ecommerce.backend.infrastructure.mapper.IOrderMapper;

public class OrderCrudRepositoryImpl implements IOrderRepository {

    private final IOrderCrudRepository iOrderCrudRepository;
    private  final IOrderMapper iOrderMapper;

    public OrderCrudRepositoryImpl(IOrderCrudRepository iOrderCrudRepository, IOrderMapper iOrderMapper) {
        this.iOrderCrudRepository = iOrderCrudRepository;
        this.iOrderMapper = iOrderMapper;
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = iOrderMapper.toOderEntity(order);
        //A cada OrderProductos(detalle) le ponemos la Order a la que pertenece:
        orderEntity.getOrderProducts().forEach(
                orderProductEntity -> orderProductEntity.setOrderEntity(orderEntity)
        );

        return iOrderMapper.toOrder(iOrderCrudRepository.save(orderEntity));
    }

    @Override
    public Order findById(Integer id) {
        return  iOrderMapper.toOrder(iOrderCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("La orden con id: " + id +" No existe")
        ));
    }

    @Override
    public Iterable<Order> findAll() {
        return iOrderMapper.toOrderList(iOrderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> findByUserId(Integer userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        return iOrderMapper.toOrderList(iOrderCrudRepository.findByUserEntity(userEntity));
    }

    @Override
    public void updateStateById(Integer id, String state) {
        if(state.equals(OrderState.CANCELED)){
            iOrderCrudRepository.updateStateById(id,OrderState.CANCELED);
        }else {
            iOrderCrudRepository.updateStateById(id,OrderState.CONFIRMED);
        }
    }
}
