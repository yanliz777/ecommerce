package com.yf.ecommerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
Data:para generar getter/setters
@AllArgsConstructor: para generar un cosntructor con todos los parametros
@NoArgsConstructor: para generar un constructor sin parametros
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String addres;
    private String cellphone;
    private String password;
    private UserType userType;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
