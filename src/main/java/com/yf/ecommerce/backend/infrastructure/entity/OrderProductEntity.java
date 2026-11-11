package com.yf.ecommerce.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "order_Products")
@Entity
@Data
@NoArgsConstructor
public class OrderProductEntity {
    @Id
    //Sirve para autoincrementar por cada resgistro un valor automatico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal quantity;
    private BigDecimal price;
    //Relación:
    private Integer productId;
    //para saber a qué orden pertenece:
    @ManyToOne //muchas ordenes de producto van a perteneces a una orden
    private OrderEntity orderEntity;
}
