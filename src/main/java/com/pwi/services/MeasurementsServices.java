package com.pwi.services;

import com.pwi.entities.MeasurementEntity;
import com.pwi.entities.ProductMeasurementsEntity;
import com.pwi.repositories.IMeasurementsRepository;
import com.pwi.repositories.IProductMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementsServices {

    @Autowired
    IMeasurementsRepository measurementsRepository;

    public List<MeasurementEntity> getPrdMeasurmentList() {
        return measurementsRepository.findAll();
    }

    public MeasurementEntity getPrdMeasurementById(int prdMeasurementID) {
        return measurementsRepository.findById(prdMeasurementID).orElseThrow(() -> new RuntimeException("Product Measurement not found"));
    }

    public MeasurementEntity createOrUpdatePrdMeasurement(MeasurementEntity measurementEntity) {
        return measurementsRepository.save(measurementEntity);
    }

    public void deletePrdMeasurement(MeasurementEntity measurementEntity) {
        measurementsRepository.delete(measurementEntity);
    }
}
