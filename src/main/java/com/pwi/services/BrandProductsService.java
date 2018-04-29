package com.pwi.services;

import com.pwi.entities.BrandProductsEntity;
import com.pwi.repositories.IBrandProductsCustomReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandProductsService {

    @Autowired
    @Qualifier("brandProductsCustomReportImpl")
    IBrandProductsCustomReport brandProductsCustomReport;

    public List<BrandProductsEntity> getBrandProducts(int brandId){
        return brandProductsCustomReport.getBrandProductsReport(brandId);
    }
}
