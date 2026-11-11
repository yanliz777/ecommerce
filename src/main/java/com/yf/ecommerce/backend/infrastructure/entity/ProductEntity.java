package com.yf.ecommerce.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "products")
@Entity
@Data
@NoArgsConstructor
public class ProductEntity {
    @Id
    //Sirve para autoincrementar por cada resgistro un valor automatico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private String description;
    private String urlImagen;
    private BigDecimal price;
    @CreationTimestamp//Para guardar la fecha y hora cuando el usuario es creado.
    private LocalDateTime dateCreated;
    @UpdateTimestamp//Para guardar la fecha y hora cuando el usuario es actualizado.
    private LocalDateTime dateUpdated;
    /*
    Relación unidireccional con la entidad User y Category: cLaves foraneas
    -Un admin puede crear uno o más productos
    -Una categoria puede tener muchos productos
     */
    @ManyToOne//Significa: Muchos productos pueden ser creados por un User.
    private UserEntity userEntity;
    @ManyToOne//Significa:Muchos productos pueden ser de una Categotia.
    private CategoryEntity categoryEntity;
}
