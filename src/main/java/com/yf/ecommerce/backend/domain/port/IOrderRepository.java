package com.yf.ecommerce.backend.domain.port;

import com.yf.ecommerce.backend.domain.model.Order;
import org.aspectj.weaver.ast.Or;

public interface IOrderRepository {
    Order save(Order order);
    Order findById(Integer id);
    Iterable<Order> findAll();
    Iterable<Order> findByUserId(Integer userId);
    void updateStateById(Integer id, String state);


}
