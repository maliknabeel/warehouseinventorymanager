package com.pwi.repositories;

import com.pwi.entities.InventoryReportByCountry;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Repository
public interface IInventoryCustomReports {
    List<InventoryReportByCountry> getProductWarehouseInventoryStatusReport(int countryId);
}
