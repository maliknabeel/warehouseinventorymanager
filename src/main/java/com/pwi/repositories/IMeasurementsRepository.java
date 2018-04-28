package com.pwi.repositories;

import com.pwi.entities.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMeasurementsRepository extends JpaRepository<MeasurementEntity,Integer> {

}
