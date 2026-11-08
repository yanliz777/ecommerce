package com.yf.ecommerce.backend.infrastructure.adapter.interfaces;

import com.yf.ecommerce.backend.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductCrudRepository extends CrudRepository<ProductEntity,Integer> {
}
