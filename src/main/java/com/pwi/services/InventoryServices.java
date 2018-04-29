package com.pwi.services;

import com.pwi.entities.InventoryEntity;
import com.pwi.repositories.IInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Service
public class InventoryServices {

    @Autowired
    IInventoryRepository inventoryRepository;

    public List<InventoryEntity> getInventoryList() {
        return inventoryRepository.findAll();
    }

    public InventoryEntity getInventoryById(int inventoryId) {
        return inventoryRepository.findById(inventoryId).orElseThrow(() -> new RuntimeException("Inventory ID not found"));
    }

    public InventoryEntity createOrUpdateInventory(InventoryEntity inventoryEntity) {
        return inventoryRepository.save(inventoryEntity);
    }

    public void deleteInventory(InventoryEntity inventoryEntity) {
        inventoryRepository.delete(inventoryEntity);
    }

}
