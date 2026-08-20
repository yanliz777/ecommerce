package com.yf.ecommerce.backend.application;

import com.yf.ecommerce.backend.domain.model.Product;
import com.yf.ecommerce.backend.domain.port.IProductRepository;

//Puertos: nos permite poder comunicarnos con el exterior, con la capa de infraestructura.
public class ProductService {

    private final IProductRepository iProductRepository;

    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    public Product save(Product product){
        return iProductRepository.save(product);
    }

    public Iterable<Product> findAll(){
        return iProductRepository.findAll();
    }
    Product findById(Integer id){
        return iProductRepository.findById(id);
    }

    public void deleteById(Integer id){
        iProductRepository.deleteById(id);
    }
}
