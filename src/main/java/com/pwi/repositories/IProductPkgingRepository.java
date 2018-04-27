package com.pwi.repositories;

import com.pwi.entities.ProductPkgingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductPkgingRepository extends JpaRepository<ProductPkgingEntity, Integer> {
}
