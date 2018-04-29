package com.pwi.services;

import com.pwi.entities.BrandsEntity;
import com.pwi.repositories.IBrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Service
public class BrandsServices {

    @Autowired
    IBrandsRepository brandsRepository;

    public List<BrandsEntity> getBrandsList() {
        return brandsRepository.findAll();
    }

    public BrandsEntity getBrandById(int brandId) {
        return brandsRepository.findById(brandId).orElseThrow(() -> new RuntimeException("Brand ID not found"));
    }

    public BrandsEntity createOrUpdateBrand(BrandsEntity brandsEntity) {
        return brandsRepository.save(brandsEntity);
    }

    public void deleteBrand(BrandsEntity brandsEntity) {
        brandsRepository.delete(brandsEntity);
    }
}
