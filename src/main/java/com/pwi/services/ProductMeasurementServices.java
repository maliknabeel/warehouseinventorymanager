package com.pwi.services;

import com.pwi.entities.ProductMeasurementEntity;
import com.pwi.repositories.IProductMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMeasurementServices {

    @Autowired
    IProductMeasurementRepository productMeasurementRepository;

    public List<ProductMeasurementEntity> getPrdMeasurmentList() {
        return productMeasurementRepository.findAll();
    }

    public ProductMeasurementEntity getPrdMeasurementById(int prdMeasurementID) {
        return productMeasurementRepository.findById(prdMeasurementID).orElseThrow(() -> new RuntimeException("Product Measurement not found"));
    }

    public ProductMeasurementEntity createOrUpdatePrdMeasurement(ProductMeasurementEntity productMeasurementEntity) {
        return productMeasurementRepository.save(productMeasurementEntity);
    }

    public void deletePrdMeasurement(ProductMeasurementEntity productMeasurementEntity) {
        productMeasurementRepository.delete(productMeasurementEntity);
    }
}
