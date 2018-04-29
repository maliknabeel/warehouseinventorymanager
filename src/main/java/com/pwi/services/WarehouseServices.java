package com.pwi.services;

import com.pwi.entities.WarehouseEntity;
import com.pwi.repositories.IWarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Service
public class WarehouseServices {

    @Autowired
    IWarehouseRepository warehouseRepository;

    public List<WarehouseEntity> getWarehouseList() {
        return warehouseRepository.findAll();
    }

    public WarehouseEntity getWarehouseById(int warehouseID) {
        return warehouseRepository.findById(warehouseID).orElseThrow(() -> new RuntimeException("Warehouse ID not found"));
    }

    public WarehouseEntity createOrUpdateWarehouse(WarehouseEntity warehouseEntity) {
        return warehouseRepository.save(warehouseEntity);
    }

    public void deleteWarehouse(WarehouseEntity warehouseEntity) {
        warehouseRepository.delete(warehouseEntity);
    }
}
