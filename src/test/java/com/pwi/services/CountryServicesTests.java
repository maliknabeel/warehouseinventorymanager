package com.pwi.services;

import com.pwi.entities.CountryEntity;
import com.pwi.repositories.ICountryRepository;
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

public class CountryServicesTests {

    @Mock
    ICountryRepository countryRepository;

    @InjectMocks
    CountryServices countryServices;

    @Spy
    private List<CountryEntity> countryList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initCountryList();
    }

    @Test
    public void listAllCountries() {
        when(countryRepository.findAll()).thenReturn(countryList);
        List<CountryEntity> countryListMock = countryServices.getCountriesList();
        assertThat(countryListMock).isEqualTo(countryList);
    }


    @Test
    public void createCountry() {
        CountryEntity countryEntity = countryList.get(1);
        countryServices.createOrUpdateCountry(countryEntity);
        verify(countryRepository, atLeastOnce()).save(countryEntity);
    }

    @Test
    public void deleteCountry() {
        CountryEntity countryEntity = countryList.get(1);
        countryServices.deleteCountry(countryEntity);
        verify(countryRepository, atLeastOnce()).delete(countryEntity);
    }

    private void initCountryList() {
        CountryEntity countryEntity;

        countryEntity = new CountryEntity();
        countryEntity.setIdCountry(9);
        countryEntity.setCountryName("Turkey");
        countryEntity.setCountryCode("TRK");
        countryEntity.setCountryContinent("Asia");
        countryList.add(countryEntity);

        countryEntity = new CountryEntity();
        countryEntity.setIdCountry(10);
        countryEntity.setCountryName("Japan");
        countryEntity.setCountryCode("JPX");
        countryEntity.setCountryContinent("Asia");
        countryList.add(countryEntity);
    }
}