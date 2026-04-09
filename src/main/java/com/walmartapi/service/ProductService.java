package com.walmartapi.service;

import com.walmartapi.Mapper.CustomObjectMapper;
import com.walmartapi.entity.ProductEntity;
import com.walmartapi.exception.NotFound;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CustomObjectMapper <ProductEntity, Product> productMapper;

    public ProductService(ProductRepository productRepository, CustomObjectMapper<ProductEntity, Product> productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product saveProduct(Product product) {
        //Mappear: agarrar informacion de un parametro para utilizarlo en una nueva entidad
        // map POJO to entity
        // Call DB
        // map entity to POJO
        ProductEntity newProduct  = productMapper.mapToEntity(product);
        ProductEntity savedEntity = productRepository.save(newProduct);
        return productMapper.mapToDto(savedEntity);
    }

    public Product getProductbyId(Long id){
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new NotFound("Product not found");
        }
        return productMapper.mapToDto(product.get());
    }

}
