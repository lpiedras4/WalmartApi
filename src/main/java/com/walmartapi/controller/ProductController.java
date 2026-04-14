package com.walmartapi.controller;

import com.walmartapi.model.Product;
import com.walmartapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}") public ResponseEntity<Product> getProduct(@PathVariable Long id){
    Product foundProduct = productService.getProductbyId(id);
    return ResponseEntity.ok(foundProduct);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping ("{id}") public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product updatedProduct = productService.updateProduct(id,product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping ("{id}") public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        Product deletedProduct = productService.getProductbyId(id);
                productService.deleteProduct(id);
        return new ResponseEntity<>("Producto eliminado " + deletedProduct, HttpStatus.OK);
    }

}
