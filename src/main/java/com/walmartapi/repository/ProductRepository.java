package com.walmartapi.repository;

import com.walmartapi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//JpaRepository es una clase que tiene metodos reutilizables para nosotros (ej. findById, Save, etc)

@Repository public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


}
