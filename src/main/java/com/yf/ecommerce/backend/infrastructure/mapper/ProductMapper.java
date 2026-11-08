package com.yf.ecommerce.backend.infrastructure.mapper;

import com.yf.ecommerce.backend.domain.model.Product;
import com.yf.ecommerce.backend.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings(
            {
                /*
                source = fuente (userEntity)
                target = objetivo (User)
                 */
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "name", target = "name"),
                    @Mapping(source = "code", target = "code"),
                    @Mapping(source = "description", target = "description"),
                    @Mapping(source = "urlImagen", target = "urlImagen"),
                    @Mapping(source = "price", target = "price"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "dateUpdated", target = "dateUpdated"),
                    //Se pone = userEntity.id porque el objeto userEntity tiene un id
                    @Mapping(source = "userEntity.id",target = "userId"),
                    @Mapping(source = "categoryEntity.id",target = "categoryId")
            }
    )
    /*
    Convierte una entidad(ProductEntity) a
    un objeto Product.
     */
    Product toProduct(ProductEntity productEntity);
    Iterable<Product> toProductList(Iterable<ProductEntity> productEntities);

    /*
   Converte un objeto Product a
   una entidad ProductEntity.
    */
    @InheritInverseConfiguration
    ProductEntity toProductEntity(Product product);
}
