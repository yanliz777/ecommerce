package com.yf.ecommerce.backend.application;

import com.yf.ecommerce.backend.domain.model.Order;
import com.yf.ecommerce.backend.domain.port.IOrderRepository;

public class OrderService {
    private final IOrderRepository iorderRepository;

    public OrderService(IOrderRepository iorderRepository) {
        this.iorderRepository = iorderRepository;
    }

    public Order save(Order order){
        return this.iorderRepository.save(order);
    }

    public Order findById(Integer id){
        return this.iorderRepository.findById(id);
    }

    Iterable<Order> findAll(){
        return this.iorderRepository.findAll();
    }

    Iterable<Order> findByUserId(Integer userId){
        return this.iorderRepository.findByUserId(userId);
    }


    public void updateStateById(Integer id, String state){
        this.iorderRepository.updateStateById(id,state);
    }

}
