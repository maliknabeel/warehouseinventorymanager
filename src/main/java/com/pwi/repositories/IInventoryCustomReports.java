package com.pwi.repositories;

import com.pwi.entities.InventoryReportByCountry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInventoryCustomReports {
    List<InventoryReportByCountry> getProductWarehouseInventoryStatusReport(int countryId);
}
