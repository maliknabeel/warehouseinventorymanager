package com.pwi.services;

import com.pwi.entities.ProductPkgingEntity;
import com.pwi.repositories.IProductPkgingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Service
public class ProductPkgingServices {

    @Autowired
    IProductPkgingRepository productPkgingRepository;

    public List<ProductPkgingEntity> getProductsPkgingList() {
        return productPkgingRepository.findAll();
    }

    public ProductPkgingEntity getProductsPkgingById(int prdPkging) {
        return productPkgingRepository.findById(prdPkging).orElseThrow(() -> new RuntimeException("Product Packaging ID not found"));
    }

    public ProductPkgingEntity createOrUpdateProductsPkging(ProductPkgingEntity productPkgingEntity) {
        return productPkgingRepository.save(productPkgingEntity);
    }

    public void deleteProductsPkging(ProductPkgingEntity productPkgingEntity) {
        productPkgingRepository.delete(productPkgingEntity);
    }
}
