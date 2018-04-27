package com.pwi.services;

import com.pwi.entities.InventoryEntity;
import com.pwi.entities.ProductPkgingEntity;
import com.pwi.entities.ProductsEntity;
import com.pwi.entities.WarehouseEntity;
import com.pwi.repositories.IInventoryRepository;
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

public class InventoryServicesTests {

    @Mock
    IInventoryRepository inventoryRepository;

    @InjectMocks
    InventoryServices inventoryServices;

    @Spy
    private List<InventoryEntity> inventoryList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initInventoryList();
    }

    @Test
    public void listAllInventory() {
        when(inventoryRepository.findAll()).thenReturn(inventoryList);
        List<InventoryEntity> inventoryListMock = inventoryServices.getInventoryList();
        assertThat(inventoryListMock).isEqualTo(inventoryList);
    }


    @Test
    public void createInventory() {
        InventoryEntity inventoryEntity = inventoryList.get(1);
        inventoryServices.createOrUpdateInventory(inventoryEntity);
        verify(inventoryRepository, atLeastOnce()).save(inventoryEntity);
    }

    @Test
    public void deleteInventory() {
        InventoryEntity inventoryEntity = inventoryList.get(1);
        inventoryServices.deleteInventory(inventoryEntity);
        verify(inventoryRepository, atLeastOnce()).save(inventoryEntity);
    }

    private void initInventoryList() {
        InventoryEntity inventoryEntity;

        ProductPkgingEntity productPkgingEntity = new ProductPkgingEntity();
        productPkgingEntity.setIdProductPkging(5);

        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setIdProducts(5);

        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setIdWarehouse(5);

        inventoryEntity = new InventoryEntity();
        inventoryEntity.setIdInventory(5);
        inventoryEntity.setFinishedInventoryCount(500);
        inventoryEntity.setInventoryAvaliableQty(400);
        inventoryEntity.setInventoryInStock(100);
        inventoryEntity.setInventoryInTransit(100);
        inventoryEntity.setInventoryMoq(200);
        inventoryEntity.setInventoryReorderPoint(400);
        inventoryEntity.setProductPkgingByInventoryProductPkging(productPkgingEntity);
        inventoryEntity.setProductsByInventoryProduct(productsEntity);
        inventoryEntity.setWarehouseByWarehouseId(warehouseEntity);
        inventoryList.add(inventoryEntity);

        inventoryEntity = new InventoryEntity();
        inventoryEntity.setIdInventory(6);
        inventoryEntity.setFinishedInventoryCount(500);
        inventoryEntity.setInventoryAvaliableQty(400);
        inventoryEntity.setInventoryInStock(100);
        inventoryEntity.setInventoryInTransit(100);
        inventoryEntity.setInventoryMoq(200);
        inventoryEntity.setInventoryReorderPoint(400);
        inventoryEntity.setProductPkgingByInventoryProductPkging(productPkgingEntity);
        inventoryEntity.setProductsByInventoryProduct(productsEntity);
        inventoryEntity.setWarehouseByWarehouseId(warehouseEntity);
        inventoryList.add(inventoryEntity);
    }
}
