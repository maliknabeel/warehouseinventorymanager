package com.pwi.services;

import com.pwi.entities.ProductMeasurementEntity;
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

public class ProductMeasurementServicesTests {

    @Mock
    IProductMeasurementRepository productMeasurementRepository;

    @InjectMocks
    ProductMeasurementServices productMeasurementServices;

    @Spy
    private List<ProductMeasurementEntity> prdMeasurementList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initPrdMeasurementList();
    }

    @Test
    public void listAllMeasurements() {
        when(productMeasurementRepository.findAll()).thenReturn(prdMeasurementList);
        List<ProductMeasurementEntity> prdMeasurementListMock = productMeasurementServices.getPrdMeasurmentList();
        assertThat(prdMeasurementListMock).isEqualTo(prdMeasurementList);
    }

    @Test
    public void createPrdMeasurement() {
        ProductMeasurementEntity productMeasurementEntity = prdMeasurementList.get(1);
        productMeasurementServices.createOrUpdatePrdMeasurement(productMeasurementEntity);
        verify(productMeasurementRepository, atLeastOnce()).save(productMeasurementEntity);
    }

    private void initPrdMeasurementList() {

        ProductMeasurementEntity productMeasurementEntity;

        productMeasurementEntity = new ProductMeasurementEntity();
        productMeasurementEntity.setIdProductMeasurement(5);
        productMeasurementEntity.setProductMeasurementDescription("Test Measurement 5");
        productMeasurementEntity.setProductMeasurementSize("750");
        productMeasurementEntity.setProductMeasurementUnit("ml");
        prdMeasurementList.add(productMeasurementEntity);

        productMeasurementEntity = new ProductMeasurementEntity();
        productMeasurementEntity.setIdProductMeasurement(6);
        productMeasurementEntity.setProductMeasurementDescription("Test Measurement 6");
        productMeasurementEntity.setProductMeasurementSize("750");
        productMeasurementEntity.setProductMeasurementUnit("units");
        prdMeasurementList.add(productMeasurementEntity);
    }
}
