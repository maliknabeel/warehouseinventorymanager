package com.pwi.services;

import com.pwi.entities.InventoryReportByCountry;
import com.pwi.repositories.IInventoryCustomReports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Service
public class InventoryCustomReportService {

    @Autowired
    @Qualifier("inventoryCustomReportsImpl")
    IInventoryCustomReports iInventoryCustomReports;

    public List<InventoryReportByCountry> getInventoryReportByCountryId(int countryId){
        return iInventoryCustomReports.getProductWarehouseInventoryStatusReport(countryId);
    }
}
