package com.yf.ecommerce.backend.infrastructure.adapter.interfaces;

import com.yf.ecommerce.backend.infrastructure.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface IcategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {

}
