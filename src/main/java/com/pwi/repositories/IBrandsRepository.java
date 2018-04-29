package com.pwi.repositories;

import com.pwi.entities.BrandsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Repository
public interface IBrandsRepository extends JpaRepository<BrandsEntity, Integer> {
}
