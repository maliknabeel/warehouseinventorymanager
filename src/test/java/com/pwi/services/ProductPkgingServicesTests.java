package com.pwi.services;

import com.pwi.entities.PkgingInformationEntity;
import com.pwi.entities.ProductPkgingEntity;
import com.pwi.entities.ProductsEntity;
import com.pwi.repositories.IProductPkgingRepository;
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

public class ProductPkgingServicesTests {

    @Mock
    IProductPkgingRepository productPkgingRepository;

    @InjectMocks
    ProductPkgingServices productPkgingServices;

    @Spy
    private List<ProductPkgingEntity> productPkgingList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initProductsPkgingList();
    }

    @Test
    public void listAllPrdPkging() {
        when(productPkgingRepository.findAll()).thenReturn(productPkgingList);
        List<ProductPkgingEntity> productPkgingListMock = productPkgingServices.getProductsPkgingList();
        assertThat(productPkgingListMock).isEqualTo(productPkgingList);
    }

    @Test
    public void createPrdPkging() {
        ProductPkgingEntity productPkgingEntity = productPkgingList.get(1);
        productPkgingServices.createOrUpdateProductsPkging(productPkgingEntity);
        verify(productPkgingRepository, atLeastOnce()).save(productPkgingEntity);
    }

    @Test
    public void deletePrdPkging() {
        ProductPkgingEntity productPkgingEntity = productPkgingList.get(1);
        productPkgingServices.deleteProductsPkging(productPkgingEntity);
        verify(productPkgingRepository, atLeastOnce()).delete(productPkgingEntity);
    }

    private void initProductsPkgingList() {
        ProductPkgingEntity productPkgingEntity;

        PkgingInformationEntity pkgingInformationEntity = new PkgingInformationEntity();
        pkgingInformationEntity.setIdPkgingInfo(5);

        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setIdProducts(5);

        productPkgingEntity = new ProductPkgingEntity();
        productPkgingEntity.setIdProductPkging(5);
        productPkgingEntity.setPkgingInformationByPkgingId(pkgingInformationEntity);
        productPkgingEntity.setProductsByProductId(productsEntity);
        productPkgingList.add(productPkgingEntity);

        productPkgingEntity = new ProductPkgingEntity();
        productPkgingEntity.setIdProductPkging(6);
        productPkgingEntity.setPkgingInformationByPkgingId(pkgingInformationEntity);
        productPkgingEntity.setProductsByProductId(productsEntity);
        productPkgingList.add(productPkgingEntity);
    }
}
