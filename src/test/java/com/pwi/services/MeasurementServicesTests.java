package com.pwi.services;

import com.pwi.entities.MeasurementEntity;
import com.pwi.entities.ProductMeasurementsEntity;
import com.pwi.repositories.IMeasurementsRepository;
import com.pwi.repositories.IProductMeasurementRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class MeasurementServicesTests {

    @Mock
    IMeasurementsRepository measurementsRepository;

    @InjectMocks
    MeasurementsServices measurementsServices;

    @Spy
    private List<MeasurementEntity> measurementEntityList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initPrdMeasurementList();
    }

    @Test
    public void listAllMeasurements() {
        when(measurementsRepository.findAll()).thenReturn(measurementEntityList);
        List<MeasurementEntity> prdMeasurementListMock = measurementsServices.getPrdMeasurmentList();
        assertThat(prdMeasurementListMock).isEqualTo(measurementEntityList);
    }

    @Test
    public void createPrdMeasurement() {
        MeasurementEntity productMeasurementEntity = measurementEntityList.get(1);
        measurementsServices.createOrUpdatePrdMeasurement(productMeasurementEntity);
        verify(measurementsRepository, atLeastOnce()).save(productMeasurementEntity);
    }

    private void initPrdMeasurementList() {

        MeasurementEntity measurementEntity;

        measurementEntity = new MeasurementEntity();
        measurementEntity.setIdProductMeasurement(5);
        measurementEntity.setProductMeasurementDescription("Test Measurement 5");
        measurementEntity.setProductMeasurementSize("750");
        measurementEntity.setProductMeasurementUnit("ml");
        measurementEntityList.add(measurementEntity);

        measurementEntity = new MeasurementEntity();
        measurementEntity.setIdProductMeasurement(6);
        measurementEntity.setProductMeasurementDescription("Test Measurement 6");
        measurementEntity.setProductMeasurementSize("750");
        measurementEntity.setProductMeasurementUnit("units");
        measurementEntityList.add(measurementEntity);
    }
}
