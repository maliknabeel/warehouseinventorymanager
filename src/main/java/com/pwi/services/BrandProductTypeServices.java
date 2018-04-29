package com.pwi.services;

import com.pwi.entities.BrandProductTypeEntity;
import com.pwi.repositories.IBrandProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Service
public class BrandProductTypeServices {

    @Autowired
    IBrandProductTypeRepository brandProductTypeRepository;

    public List<BrandProductTypeEntity> getProductsTypeList() {
        return brandProductTypeRepository.findAll();
    }

    public BrandProductTypeEntity getProductsTypeById(int productTypeId) {
        return brandProductTypeRepository.findById(productTypeId).orElseThrow(() -> new RuntimeException("Brand Product ID not found"));
    }

    public BrandProductTypeEntity createOrUpdateProductsType(BrandProductTypeEntity brandProductTypeEntity) {
        return brandProductTypeRepository.save(brandProductTypeEntity);
    }

    public void deleteProductsType(BrandProductTypeEntity brandProductTypeEntity) {
        brandProductTypeRepository.delete(brandProductTypeEntity);
    }
}
