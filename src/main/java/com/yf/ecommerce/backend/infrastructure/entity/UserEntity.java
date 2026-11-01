package com.yf.ecommerce.backend.infrastructure;

import com.yf.ecommerce.backend.domain.model.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

//Esta clas ese mapea como una trabla en la BD:
@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String addres;
    private String cellphone;
    private String password;
    @Enumerated(EnumType.STRING)//para que la mapee como string(varchar en bd).
    private UserType userType;
    @CreationTimestamp//Para guardar la fecha y hora cuando el usuario es creado.
    private LocalDateTime dateCreated;
    @UpdateTimestamp//Para guardar la fecha y hora cuando el usuario es actualizado.
    private LocalDateTime dateUpdated;
}
