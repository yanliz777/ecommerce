package com.yf.ecommerce.backend.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order {

    private Integer id;
    private LocalDateTime dateCreated;
    //Relación: Una orden puede tener muchas ordenes de productos:
    private List<OrderProduct> orderProducts;
    private OrderState orderState;
    //Una orden tiene un comprador:
    private Integer userId;


    public Order() {
        orderProducts = new ArrayList<>();
    }

    //Para calcular el total de todos los productos comprados:
    public BigDecimal getTotalOrderPrice(){
        return this.orderProducts.stream().map(orderProduct ->
                orderProduct.getTotalItem()).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

}
