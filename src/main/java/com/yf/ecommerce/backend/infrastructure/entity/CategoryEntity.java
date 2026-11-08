package com.yf.ecommerce.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name = "categories")
@Entity
@Data
@NoArgsConstructor
public class CategoryEntity {
    @Id
    //Sirve para autoincrementar por cada resgistro un valor automatico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @CreationTimestamp//Para guardar la fecha y hora cuando el usuario es creado.
    private LocalDateTime dateCreated;
    @UpdateTimestamp//Para guardar la fecha y hora cuando el usuario es actualizado.
    private LocalDateTime dateUpdated;
}
