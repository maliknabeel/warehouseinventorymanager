package com.pwi.repositories;

import com.pwi.entities.BrandProductsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Repository
public interface IBrandProductsCustomReport {
    List<BrandProductsEntity> getBrandProductsReport(int brandId);
}
