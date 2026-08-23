package com.yf.ecommerce.backend.application;

import com.yf.ecommerce.backend.domain.model.Category;
import com.yf.ecommerce.backend.domain.port.ICategoryRepository;

//Puertos: nos permite poder comunicarnos con el exterior, con la capa de infraestructura.
public class CategoryService {

    //Puerto:
    private final ICategoryRepository iCategoryRepository;

    /*
    Inyección de dependencia:
    La clase declara sus dependencias como
    final(iCategoryRepository) y las recibe servidas desde afuera por
    parámetro en el constructor.
     */
    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    public Category save(Category category){
        return iCategoryRepository.save(category);
    }

    public Iterable<Category> findAll(){
        return iCategoryRepository.findAll();
    }

    public Category findById(Integer id){
        return iCategoryRepository.findById(id);
    }

    public void deleteById(Integer id){
        iCategoryRepository.deletById(id);
    }
}
