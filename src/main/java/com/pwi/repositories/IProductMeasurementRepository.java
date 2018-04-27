package com.pwi.repositories;

import com.pwi.entities.ProductMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductMeasurementRepository extends JpaRepository<ProductMeasurementEntity, Integer> {
}
