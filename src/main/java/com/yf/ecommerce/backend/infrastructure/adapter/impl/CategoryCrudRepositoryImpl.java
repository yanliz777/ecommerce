package com.yf.ecommerce.backend.infrastructure.adapter.impl;
//video 31
import com.yf.ecommerce.backend.domain.model.Category;
import com.yf.ecommerce.backend.domain.port.ICategoryRepository;
import com.yf.ecommerce.backend.infrastructure.adapter.interfaces.IcategoryCrudRepository;
import com.yf.ecommerce.backend.infrastructure.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryCrudRepositoryImpl implements ICategoryRepository {

    private final IcategoryCrudRepository icategoryCrudRepository;
    private final CategoryMapper categoryMapper;

    public CategoryCrudRepositoryImpl(IcategoryCrudRepository icategoryCrudRepository, CategoryMapper categoryMapper) {
        this.icategoryCrudRepository = icategoryCrudRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category save(Category category) {
        return categoryMapper.toCategory(icategoryCrudRepository.save(categoryMapper.toCategoryEntity(category)));
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryMapper.toCategoryList(icategoryCrudRepository.findAll());
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.toCategory(icategoryCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("La categoria con id: " + id +" No existe el objeto")
        ));
    }

    @Override
    public void deletById(Integer id) {
        icategoryCrudRepository.deleteById(id);
    }
}
