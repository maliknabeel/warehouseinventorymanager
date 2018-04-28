package com.pwi.repositories;

import com.pwi.entities.ProductMeasurementsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductMeasurementRepository extends JpaRepository<ProductMeasurementsEntity, Integer> {

    /**
     * @param productId
     * @return List<ProductMeasurementEntity>
     */
    @Query(name="productmeasurements")
    List<ProductMeasurementsEntity> getMeasurementsForAProduct(int productId);
}
