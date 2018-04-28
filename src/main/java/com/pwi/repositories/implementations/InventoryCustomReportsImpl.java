package com.pwi.repositories.implementations;

import com.pwi.entities.InventoryReportByCountry;
import com.pwi.repositories.IInventoryCustomReports;
import com.pwi.services.InventoryCustomReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class InventoryCustomReportsImpl implements IInventoryCustomReports {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<InventoryReportByCountry> getProductWarehouseInventoryStatusReport(int countryId) {
        return entityManager.createNamedQuery("inventoryByCountry", InventoryReportByCountry.class).setParameter(1,countryId).getResultList();

    }
}
