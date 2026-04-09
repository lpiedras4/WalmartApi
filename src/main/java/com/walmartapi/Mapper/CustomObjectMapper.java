package com.walmartapi.Mapper;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.model.Product;

import javax.swing.text.html.parser.Entity;

public interface CustomObjectMapper <E, D> {
    E mapToEntity(D dto);

    D mapToDto(ProductEntity entity);


}
