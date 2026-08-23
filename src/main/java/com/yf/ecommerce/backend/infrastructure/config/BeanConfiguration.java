package com.yf.ecommerce.backend.infrastructure.config;

import com.yf.ecommerce.backend.application.UserService;
import com.yf.ecommerce.backend.domain.port.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
En esta clase declaramos varios beans.
Un bean  en Spring Boot es simplemente un objeto de Java
que es creado, administrado y destruido por Spring, en lugar
de ser creado por nosotros manualmente con new MiClase().
Es un componente y puede ser inyectado en cualquier otra parte del proyecto.
 */
@Configuration
public class BeanConfiguration {

    /*
    Con la anotación @Bean en clases de @Configuration
    se usa cuando quieres convertir en Bean un objeto de una clase
    que quieres que se gestione por spring o un objeto de una librería externa
    que necesitemso utilizar.
     */
    @Bean
    public UserService userService(IUserRepository iUserRepository){
        UserService userService = new UserService(iUserRepository);
        return userService;
    }


}
