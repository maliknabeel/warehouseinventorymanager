package com.pwi.repositories.implementations;

import com.pwi.entities.BrandProductsEntity;
import com.pwi.repositories.IBrandProductsCustomReport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Repository
@Transactional(readOnly = true)
public class BrandProductsCustomReportImpl implements IBrandProductsCustomReport {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<BrandProductsEntity> getBrandProductsReport(int brandId) {
        return entityManager.createNamedQuery("brandProductsReport", BrandProductsEntity.class).setParameter(1,brandId).getResultList();
    }
}
