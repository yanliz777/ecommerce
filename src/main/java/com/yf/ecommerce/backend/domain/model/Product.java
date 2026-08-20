package com.yf.ecommerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String code;
    private String description;
    private String urlImagen;
    private BigDecimal price;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdate;
    //relaciona al usuario que lo subio(ADMIN):
    private Integer userId;
    //una categoria puede tener muchos productos(llave foranea):
    private Integer categoryId;
}
