package com.pwi.repositories;

import com.pwi.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsRepository extends JpaRepository<ProductsEntity, Integer> {
}
