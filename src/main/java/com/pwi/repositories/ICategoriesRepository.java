package com.pwi.repositories;

import com.pwi.entities.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriesRepository extends JpaRepository<CategoriesEntity, Integer> {
}
