package com.pwi.services;

import com.pwi.entities.CountryEntity;
import com.pwi.repositories.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Service
public class CountryServices {

    @Autowired
    ICountryRepository ICountryRepository;

    public List<CountryEntity> getCountriesList() {
        return ICountryRepository.findAll();
    }

    public CountryEntity getCountryById(int countryID) {
        return ICountryRepository.findById(countryID).orElseThrow(() -> new RuntimeException("Country ID not found"));
    }

    public CountryEntity createOrUpdateCountry(CountryEntity countryEntity) {
        return ICountryRepository.save(countryEntity);
    }

    public void deleteCountry(CountryEntity countryEntity) {
        ICountryRepository.delete(countryEntity);
    }
}
