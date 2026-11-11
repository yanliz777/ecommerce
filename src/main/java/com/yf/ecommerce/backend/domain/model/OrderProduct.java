package com.yf.ecommerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

//Clase que representa los detalles de una orden:

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {
    private Integer id;
    private BigDecimal quantity;
    private BigDecimal price;
    //Relación:
    private Integer productId;

    //Calcular las unidades por producto:
    public BigDecimal getTotalItem(){
        return this.price.multiply(quantity);
    }

}
