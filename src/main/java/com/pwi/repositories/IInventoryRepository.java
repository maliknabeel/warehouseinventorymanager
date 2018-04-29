package com.pwi.repositories;

import com.pwi.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Repository
public interface IInventoryRepository extends JpaRepository<InventoryEntity, Integer>{

}
