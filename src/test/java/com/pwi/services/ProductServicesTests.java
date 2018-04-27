package com.pwi.services;

import com.pwi.entities.*;
import com.pwi.repositories.IProductsRepository;
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

public class ProductServicesTests {

    @Mock
    IProductsRepository productsRepository;

    @InjectMocks
    ProductServices productServices;

    @Spy
    private List<ProductsEntity> productsList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initProductsList();
    }

    @Test
    public void listAllProducts() {
        when(productsRepository.findAll()).thenReturn(productsList);
        List<ProductsEntity> productsListMock = productServices.getProductsList();
        assertThat(productsListMock).isEqualTo(productsList);
    }

    @Test
    public void createProcuct() {
        ProductsEntity productsEntity = productsList.get(1);
        productServices.createOrUpdateProducts(productsEntity);
        verify(productsRepository, atLeastOnce()).save(productsEntity);
    }

    @Test
    public void deleteProduct() {
        ProductsEntity productsEntity = productsList.get(1);
        productServices.deletePProduct(productsEntity);
        verify(productsRepository, atLeastOnce()).delete(productsEntity);
    }

    private void initProductsList() {
        ProductsEntity productsEntity;

        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setIdCountry(10);

        BrandsEntity brandsEntity = new BrandsEntity();
        brandsEntity.setIdBrands(5);

        ProductMeasurementEntity productMeasurementEntity = new ProductMeasurementEntity();
        productMeasurementEntity.setIdProductMeasurement(5);

        BrandProductTypeEntity brandProductTypeEntity = new BrandProductTypeEntity();
        brandProductTypeEntity.setIdProductType(5);

        productsEntity = new ProductsEntity();
        productsEntity.setIdProducts(5);
        productsEntity.setProductName("Test Product 5");
        productsEntity.setCountryByProductCountry(countryEntity);
        productsEntity.setBrandsByProductBrand(brandsEntity);
        productsEntity.setProductMeasurementByProductMeasurement(productMeasurementEntity);
        productsEntity.setBrandProductTypeByProductType(brandProductTypeEntity);
        productsList.add(productsEntity);

        productsEntity = new ProductsEntity();
        productsEntity.setIdProducts(6);
        productsEntity.setProductName("Test Product 6");
        productsEntity.setCountryByProductCountry(countryEntity);
        productsEntity.setBrandsByProductBrand(brandsEntity);
        productsEntity.setProductMeasurementByProductMeasurement(productMeasurementEntity);
        productsEntity.setBrandProductTypeByProductType(brandProductTypeEntity);
        productsList.add(productsEntity);
    }
}
