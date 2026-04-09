package com.walmartapi.Mapper.impl;

import com.walmartapi.Mapper.CustomObjectMapper;
import com.walmartapi.entity.ProductEntity;
import com.walmartapi.model.Product;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
@Component //@Component:
public class ProductMapper implements CustomObjectMapper<ProductEntity, Product> {
    @Override
    public ProductEntity mapToEntity(Product dto) {
        //dto --> Data Transfer Object
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(dto.getDescription());
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        return productEntity;
    }

    @Override
    public Product mapToDto(ProductEntity entity) {
        Product savedProduct = new Product();
        savedProduct.setName(entity.getName());
        savedProduct.setId(entity.getId());
        savedProduct.setDescription(entity.getDescription());
        savedProduct.setPrice(entity.getPrice());
        return savedProduct;
    }
}
