package com.pwi.repositories;

import com.pwi.entities.ProductPkgingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Repository
public interface IProductPkgingRepository extends JpaRepository<ProductPkgingEntity, Integer> {
}
