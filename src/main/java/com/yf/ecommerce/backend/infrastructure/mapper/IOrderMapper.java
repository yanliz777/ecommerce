package com.yf.ecommerce.backend.infrastructure.mapper;

import com.yf.ecommerce.backend.domain.model.Order;
import com.yf.ecommerce.backend.infrastructure.entity.OrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/*
• uses = ...: Permite reutilizar otros mappers cuando tus objetos
son complejos y tienen otros objetos adentro. Por ejemplo, si vas a
convertir un objeto Factura que adentro contiene una lista de Productos,
en uses le pasas el ProductoMapper.class para que MapStruct sepa cómo convertir
esa lista interna sin que tengas que volver a programar esa lógica.
Si son varios objeto ponemos {IOrderProductMapper.class, ... , }

 */
@Mapper(componentModel = "spring", uses = IOrderProductMapper.class)
public interface IOrderMapper {
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "orderProducts", target = "orderProducts"),
                    @Mapping(source = "orderState", target = "orderState"),
                    @Mapping(source = "userEntity.id", target = "userId")

            }
    )
    Order toOrder(OrderEntity orderEntity);
    Iterable<Order> toOrderList(Iterable<OrderEntity> orderEntities);

    @InheritInverseConfiguration
    OrderEntity toOderEntity(Order order);
}
