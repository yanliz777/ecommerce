package com.yf.ecommerce.backend.infrastructure.adapter.impl;

import com.yf.ecommerce.backend.domain.model.Product;
import com.yf.ecommerce.backend.domain.port.IProductRepository;
import com.yf.ecommerce.backend.infrastructure.adapter.interfaces.IProductCrudRepository;
import com.yf.ecommerce.backend.infrastructure.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCrudRepositoryImpl implements IProductRepository {

    private final IProductCrudRepository iProductCrudRepository;
    private final ProductMapper productMapper;

    public ProductCrudRepositoryImpl(IProductCrudRepository iProductCrudRepository, ProductMapper productMapper) {
        this.iProductCrudRepository = iProductCrudRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(iProductCrudRepository.save(productMapper.toProductEntity(product)));
    }

    @Override
    public Iterable<Product> findAll() {
        return productMapper.toProductList(iProductCrudRepository.findAll());
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.toProduct(iProductCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("El producto con id: " + id +" No existe")
        ));
    }

    @Override
    public void deleteById(Integer id) {

        iProductCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("El producto con id: " + id +" No existe")
        );

        iProductCrudRepository.deleteById(id);
    }
}
