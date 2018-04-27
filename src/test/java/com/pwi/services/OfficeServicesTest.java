package com.pwi.services;

import com.pwi.entities.CountryEntity;
import com.pwi.entities.OfficesEntity;
import com.pwi.repositories.IOfficesRepository;
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

public class OfficeServicesTest {

    @Mock
    IOfficesRepository officesRepository;

    @InjectMocks
    OfficesServices officesServices;

    @Spy
    private List<OfficesEntity> officesList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initOfficeList();
    }

    @Test
    public void listAlloffices() {
        when(officesRepository.findAll()).thenReturn(officesList);
        List<OfficesEntity> officesListMock = officesServices.getOfficesList();
        assertThat(officesListMock).isEqualTo(officesList);
    }

    @Test
    public void createOffice() {
        OfficesEntity officesEntity = officesList.get(1);
        officesServices.createOrUpdateOffice(officesEntity);
        verify(officesRepository, atLeastOnce()).save(officesEntity);
    }

    @Test
    public void deleteOffice() {
        OfficesEntity officesEntity = officesList.get(1);
        officesServices.deleteOffice(officesEntity);
        verify(officesRepository, atLeastOnce()).save(officesEntity);
    }

    private void initOfficeList() {

        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setIdCountry(5);

        OfficesEntity officesEntity;
        officesEntity = new OfficesEntity();

        officesEntity.setIdOffices(5);
        officesEntity.setOfficeName("Test Office 5");
        officesEntity.setOfficeAddress("Test Address 5");
        officesEntity.setCountryByOfficesCountry(countryEntity);
        officesList.add(officesEntity);

        officesEntity.setIdOffices(6);
        officesEntity.setOfficeName("Test Office 6");
        officesEntity.setOfficeAddress("Test Address 6");
        officesEntity.setCountryByOfficesCountry(countryEntity);
        officesList.add(officesEntity);
    }
}
