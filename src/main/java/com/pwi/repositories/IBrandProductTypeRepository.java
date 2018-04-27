package com.pwi.repositories;

import com.pwi.entities.BrandProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBrandProductTypeRepository extends JpaRepository<BrandProductTypeEntity, Integer> {
}
