package com.pwi.services;

import com.pwi.entities.ProductsEntity;
import com.pwi.repositories.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Service
public class ProductServices {

    @Autowired
    IProductsRepository productsRepository;
    public List<ProductsEntity> getProductsList() {
        return productsRepository.findAll();
    }

    public ProductsEntity getProductById(int productId) {
        return productsRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public ProductsEntity createOrUpdateProducts(ProductsEntity productsEntity) {
        return productsRepository.save(productsEntity);
    }

    public void deletePProduct(ProductsEntity productsEntity) {
        productsRepository.delete(productsEntity);
    }
}
