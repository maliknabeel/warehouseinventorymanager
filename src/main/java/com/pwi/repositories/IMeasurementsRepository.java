package com.pwi.repositories;

import com.pwi.entities.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Repository
public interface IMeasurementsRepository extends JpaRepository<MeasurementEntity,Integer> {

    @Query( name = "productsMeasurements",
            value = "select m.id_product_measurement, m.product_measurement_size, " +
                    "m.product_measurement_description, m.product_measurement_unit " +
                    "from measurement m, products p, product_measurements pm\n" +
            "where pm.product_id = p.id_products\n" +
            "and pm.measurement_id = m.id_product_measurement\n" +
            "and pm.product_id = :productId",
            nativeQuery = true)
    List<MeasurementEntity> getMeasurementsForAProduct(@Param("productId") int productId);
}
