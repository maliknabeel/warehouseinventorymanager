package com.pwi.services;

import com.pwi.entities.CountryEntity;
import com.pwi.entities.WarehouseEntity;
import com.pwi.repositories.IWarehouseRepository;
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

public class WarehouseServicesTest {

    @Mock
    IWarehouseRepository warehouseRepository;

    @InjectMocks
    WarehouseServices warehouseServices;

    @Spy
    private List<WarehouseEntity> warehouseList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initWarehouseList();
    }

    @Test
    public void listAllWarehouses() {
        when(warehouseRepository.findAll()).thenReturn(warehouseList);
        List<WarehouseEntity> warehouseListMock = warehouseServices.getWarehouseList();
        assertThat(warehouseListMock).isEqualTo(warehouseList);
    }

    @Test
    public void createWarehouse() {
        WarehouseEntity warehouseEntity = warehouseList.get(1);
        warehouseServices.createOrUpdateWarehouse(warehouseEntity);
        verify(warehouseRepository, atLeastOnce()).save(warehouseEntity);
    }

    @Test
    public void deleteWarehouse() {
        WarehouseEntity warehouseEntity = warehouseList.get(1);
        warehouseServices.deleteWarehouse(warehouseEntity);
        verify(warehouseRepository, atLeastOnce()).delete(warehouseEntity);
    }

    private void initWarehouseList() {

        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setIdCountry(5);

        WarehouseEntity warehouseEntity;
        warehouseEntity = new WarehouseEntity();
        warehouseEntity.setIdWarehouse(5);
        warehouseEntity.setWarehouseName("Warehouse 5");
        warehouseEntity.setWarehouseAddress("This is test warehouse 5");
        warehouseEntity.setCountryByWarehouseCountry(countryEntity);
        warehouseList.add(warehouseEntity);

        warehouseEntity = new WarehouseEntity();
        warehouseEntity.setIdWarehouse(6);
        warehouseEntity.setWarehouseName("Warehouse 6");
        warehouseEntity.setWarehouseAddress("This is test warehouse 6");
        warehouseEntity.setCountryByWarehouseCountry(countryEntity);
        warehouseList.add(warehouseEntity);
    }
}
