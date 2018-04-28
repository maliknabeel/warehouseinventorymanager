package com.pwi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SqlResultSetMapping(name="warehouseInvetoryByCountry",
entities = {
        @EntityResult(entityClass = InventoryReportByCountry.class,
        fields = {
                @FieldResult(name = "idInventoryReport", column = "idInventoryReport"),
                @FieldResult(name = "warehouseName", column = "warehouseName"),
                @FieldResult(name = "item", column = "item"),
                @FieldResult(name = "size", column = "size"),
                @FieldResult(name = "finishedInventoryCount", column = "finishedInventoryCount"),
                @FieldResult(name = "inventoryInStock", column = "inventoryInStock"),
                @FieldResult(name = "inventoryInTransit", column = "inventoryInTransit"),
                @FieldResult(name = "inventoryAvaliableQty", column = "inventoryAvaliableQty"),
                @FieldResult(name = "inventoryMoq", column = "inventoryMoq"),
                @FieldResult(name = "inventoryReorderPoint", column = "inventoryReorderPoint"),
        })
})

@NamedNativeQuery(name="inventoryByCountry",
        query = "SELECT i.id_inventory as idInventoryReport, w.warehouse_name as warehouseName, " +
                "p.product_name as item, m.product_measurement_size as size, " +
                "i.finished_inventory_count as finishedInventoryCount,i.inventory_in_stock as inventoryInStock," +
                "i.inventory_in_transit as inventoryInTransit," +
                "i.inventory_avaliable_qty as inventoryAvaliableQty," +
                "i.inventory_moq as inventoryMoq, i.inventory_reorder_point as inventoryReorderPoint \n" +
                "from warehouse w,inventory i, products p, product_measurements pm, measurement m\n" +
                "where i.warehouse_id = w.id_warehouse \n" +
                "AND i.inventory_product = p.id_products\n" +
                "AND p.id_products = pm.idproduct_measurements\n" +
                "AND pm.idproduct_measurements = m.id_product_measurement\n" +
                "AND w.warehouse_country = ?",
        resultClass = InventoryReportByCountry.class
)

public class InventoryReportByCountry implements Serializable {

    @Id
    @JsonIgnore
    private int idInventoryReport;
    private String warehouseName;
    private String item;
    private String size;
    private Integer finishedInventoryCount;
    private Integer inventoryInStock;
    private Integer inventoryInTransit;
    private Integer inventoryAvaliableQty;
    private Integer inventoryMoq;
    private Integer inventoryReorderPoint;

    public int getIdinventoryReport() {
        return idInventoryReport;
    }

    public void setIdinventoryReport(int idInventoryReport) {
        this.idInventoryReport = idInventoryReport;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getFinishedInventoryCount() {
        return finishedInventoryCount;
    }

    public void setFinishedInventoryCount(Integer finishedInventoryCount) {
        this.finishedInventoryCount = finishedInventoryCount;
    }

    public Integer getInventoryInStock() {
        return inventoryInStock;
    }

    public void setInventoryInStock(Integer inventoryInStock) {
        this.inventoryInStock = inventoryInStock;
    }

    public Integer getInventoryInTransit() {
        return inventoryInTransit;
    }

    public void setInventoryInTransit(Integer inventoryInTransit) {
        this.inventoryInTransit = inventoryInTransit;
    }

    public Integer getInventoryAvaliableQty() {
        return inventoryAvaliableQty;
    }

    public void setInventoryAvaliableQty(Integer inventoryAvaliableQty) {
        this.inventoryAvaliableQty = inventoryAvaliableQty;
    }

    public Integer getInventoryMoq() {
        return inventoryMoq;
    }

    public void setInventoryMoq(Integer inventoryMoq) {
        this.inventoryMoq = inventoryMoq;
    }

    public Integer getInventoryReorderPoint() {
        return inventoryReorderPoint;
    }

    public void setInventoryReorderPoint(Integer inventoryReorderPoint) {
        this.inventoryReorderPoint = inventoryReorderPoint;
    }
}
