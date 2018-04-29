package com.pwi.repositories;

import com.pwi.entities.ProductMeasurementsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Repository
public interface IProductMeasurementRepository extends JpaRepository<ProductMeasurementsEntity, Integer> {
}
