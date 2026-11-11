package com.yf.ecommerce.backend.infrastructure.entity;


import com.yf.ecommerce.backend.domain.model.OrderState;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class OrderEntity {
    @Id
    //Sirve para autoincrementar por cada resgistro un valor automatico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @Enumerated(value = EnumType.STRING)
    private OrderState orderState;
    //relación: Para registrar a que cliente pertenece la orden.
    @ManyToOne //muchas ordenes van a estar asocioadas a un usuario:
    private UserEntity userEntity;
    /*
      Una orden va a tener una lista de items/ordenes de productos.
      CascadeType.PERSIST = indica que cuando se cree una orden automaticamente
      inserte los items para esa orden. Y se mapea con orderEntity de la entidad
      OrderProductEntity.
     */
    @OneToMany(mappedBy = "orderEntity" , cascade = CascadeType.PERSIST) //una orden puede tener muchas ordenes de productos
    private List<OrderProductEntity> orderProducts;
}
