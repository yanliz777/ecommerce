package com.yf.ecommerce.backend.domain.port;

import com.yf.ecommerce.backend.domain.model.Category;

public interface ICategoryRepository {

    Category save(Category category);
    Iterable<Category> findAll();
    Category findById(Integer id);
    void deletById(Integer id);
}
