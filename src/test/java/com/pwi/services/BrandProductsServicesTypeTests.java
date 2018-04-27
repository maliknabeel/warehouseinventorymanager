package com.pwi.services;

import com.pwi.entities.BrandProductTypeEntity;
import com.pwi.repositories.IBrandProductTypeRepository;
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

public class BrandProductsServicesTypeTests {

    @Mock
    IBrandProductTypeRepository brandProductTypeRepository;

    @InjectMocks
    BrandProductTypeServices brandProductTypeServices;

    @Spy
    private List<BrandProductTypeEntity> brandProductList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initBrandProductsTypeList();
    }

    @Test
    public void listAllBrandProductsType() {
        when(brandProductTypeRepository.findAll()).thenReturn(brandProductList);
        List<BrandProductTypeEntity> brandProductTypeListMock = brandProductTypeServices.getProductsTypeList();
        assertThat(brandProductTypeListMock).isEqualTo(brandProductList);
    }

    @Test
    public void createBrandProcuctType() {
        BrandProductTypeEntity brandProductTypeEntity = brandProductList.get(1);
        brandProductTypeServices.createOrUpdateProductsType(brandProductTypeEntity);
        verify(brandProductTypeRepository, atLeastOnce()).save(brandProductTypeEntity);
    }

    private void initBrandProductsTypeList() {
        BrandProductTypeEntity brandProductTypeEntity;

        brandProductTypeEntity = new BrandProductTypeEntity();
        brandProductTypeEntity.setIdProductType(5);
        brandProductTypeEntity.setProductType("Test Type 5");
        brandProductTypeEntity.setProductTypeDescription("Test description 5");
        brandProductList.add(brandProductTypeEntity);


        brandProductTypeEntity = new BrandProductTypeEntity();
        brandProductTypeEntity.setIdProductType(6);
        brandProductTypeEntity.setProductType("Test Type 6");
        brandProductTypeEntity.setProductTypeDescription("Test description 6");
        brandProductList.add(brandProductTypeEntity);
    }
}
