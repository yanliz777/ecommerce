package com.yf.ecommerce.backend.infrastructure.rest;

import com.yf.ecommerce.backend.application.UserService;
import com.yf.ecommerce.backend.domain.model.User;
import org.springframework.web.bind.annotation.*;

/*
@RestController: Se usa cuando construyes una API REST desacoplada.
No devuelve páginas HTML, sino datos crudos en formato JSON o XML.

@RequestMapping(): es una etiqueta (o anotación) de Spring Boot que
sirve para crear una dirección web (URL) en nuestra aplicación.
ejemplo:  http://localhost:8085/api/v1/users
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    //inyectamos UserService:
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
    @RequestBody: es una etiqueta de Spring Boot que sirve para recibir datos que
    vienen desde internet(en formato JSON) y convertirlos automáticamente en un
    objeto de Java.la etiqueta se encarga de abrir la caja, sacar los datos y
    acomodarlos en tu clase de Java para que puedas usarlos.
    Solo funciona con POST, PUT y PATCH: Se usa únicamente cuando el cliente (el navegador o la app)
    nos está enviando información para crear o modificar algo.
     */
    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    /*
    @PathVariable= es una etiqueta de Spring Boot que sirve para extraer un dato que viene
    escrito directamente dentro de la dirección web (URL).
    se usa para identificar un dato específico en la ruta, casi
    siempre el número de ID de un registro.

    http://localhost:8085/api/v1/users/4
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }

}
