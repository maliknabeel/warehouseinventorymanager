package com.pwi.repositories;

import com.pwi.entities.BrandProductsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBrandProductsCustomReport {
    List<BrandProductsEntity> getBrandProductsReport(int brandId);
}
