package com.yf.ecommerce.backend.application;

import com.yf.ecommerce.backend.domain.model.User;
import com.yf.ecommerce.backend.domain.port.IUserRepository;

//Puertos: nos permite poder comunicarnos con el exterior, con la capa de infraestructura.
public class UserService {

    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User save(User user){
        return iUserRepository.save(user);
    }

    public User findById(Integer id){
        return iUserRepository.findById(id);
    }
}
