package com.yf.ecommerce.backend.domain.port;

import com.yf.ecommerce.backend.domain.model.Product;

//Puertos
public interface IProductRepository {

    Product save(Product product);
    Iterable<Product> findAll();
    Product findById(Integer id);
    void deleteById(Integer id);
}
