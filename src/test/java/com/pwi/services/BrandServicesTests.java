package com.pwi.services;

import com.pwi.entities.BrandsEntity;
import com.pwi.entities.CategoriesEntity;
import com.pwi.entities.CountryEntity;
import com.pwi.repositories.IBrandsRepository;
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

public class BrandServicesTests {
    @Mock
    IBrandsRepository brandsRepository;

    @InjectMocks
    BrandsServices brandsServices;

    @Spy
    private List<BrandsEntity> brandsList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initBrandsList();
    }

    @Test
    public void listAllBrands() {
        when(brandsRepository.findAll()).thenReturn(brandsList);
        List<BrandsEntity> brandsListMock = brandsServices.getBrandsList();
        assertThat(brandsListMock).isEqualTo(brandsList);
    }

//    @Test
//    public void findBrandById() {
//        BrandsEntity brandsEntity = brandsServices.getBrandById(5);
//        when(brandsRepository.findById(anyInt()).orElseThrow(() -> new RuntimeException("Brand not found"))).thenReturn(brandsEntity);
//        assertThat(brandsEntity).isEqualTo(brandsList.get(0));
//    }

    @Test
    public void createBrand() {
        BrandsEntity brandsEntity = brandsList.get(1);
        brandsServices.createOrUpdateBrand(brandsEntity);
        verify(brandsRepository, atLeastOnce()).save(brandsEntity);
    }

    @Test
    public void deleteBrand() {
        BrandsEntity brandsEntity = brandsList.get(1);
        brandsServices.deleteBrand(brandsEntity);
        verify(brandsRepository, atLeastOnce()).delete(brandsEntity);
    }

    private void initBrandsList() {
        BrandsEntity brandsEntity;

        brandsEntity = new BrandsEntity();
        brandsEntity.setIdBrands(5);
        brandsEntity.setBrandName("Test Brand");
        brandsEntity.setBrandDescription("Test Brand Description");

        CategoriesEntity categoriesEntity = new CategoriesEntity();
        categoriesEntity.setIdCategory(5);
        categoriesEntity.setCategoryDescription("Test Category");
        categoriesEntity.setCategoryName("Test Category");
        brandsEntity.setCategoriesByBrandCategory(categoriesEntity);

        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setIdCountry(10);
        countryEntity.setCountryName("Japan");
        countryEntity.setCountryCode("JPX");
        countryEntity.setCountryContinent("Asia");
        brandsEntity.setCountryByBrandCountry(countryEntity);

        brandsList.add(brandsEntity);

        brandsEntity = new BrandsEntity();
        brandsEntity.setIdBrands(6);
        brandsEntity.setBrandName("Test Brand");
        brandsEntity.setBrandDescription("Test Brand Name Description");

        categoriesEntity = new CategoriesEntity();
        categoriesEntity.setIdCategory(6);
        categoriesEntity.setCategoryDescription("Test Category");
        categoriesEntity.setCategoryName("Test Category");
        brandsEntity.setCategoriesByBrandCategory(categoriesEntity);

        countryEntity = new CountryEntity();
        countryEntity.setIdCountry(11);
        countryEntity.setCountryName("Japan");
        countryEntity.setCountryCode("JPX");
        countryEntity.setCountryContinent("Asia");
        brandsEntity.setCountryByBrandCountry(countryEntity);

        brandsList.add(brandsEntity);
    }
}
