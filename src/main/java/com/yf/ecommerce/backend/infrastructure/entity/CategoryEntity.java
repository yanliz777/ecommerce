package com.yf.ecommerce.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdate;
}
