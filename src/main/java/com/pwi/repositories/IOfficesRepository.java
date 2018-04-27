package com.pwi.repositories;

import com.pwi.entities.OfficesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOfficesRepository extends JpaRepository<OfficesEntity, Integer> {
}
