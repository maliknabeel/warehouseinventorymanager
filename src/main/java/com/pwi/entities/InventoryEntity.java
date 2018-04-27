package com.pwi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "inventory", schema = "vtb_pwi")
public class InventoryEntity implements Serializable {
    private int idInventory;
    private Integer finishedInventoryCount;
    private Integer inventoryInStock;
    private Integer inventoryInTransit;
    private Integer inventoryAvaliableQty;
    private Integer inventoryMoq;
    private Integer inventoryReorderPoint;
    private ProductsEntity productsByInventoryProduct;
    private ProductPkgingEntity productPkgingByInventoryProductPkging;
    private WarehouseEntity warehouseByWarehouseId;

    @Id
    @Column(name = "id_inventory")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
    }

    @Basic
    @Column(name = "finished_inventory_count")
    public Integer getFinishedInventoryCount() {
        return finishedInventoryCount;
    }

    public void setFinishedInventoryCount(Integer finishedInventoryCount) {
        this.finishedInventoryCount = finishedInventoryCount;
    }

    @Basic
    @Column(name = "inventory_in_stock")
    public Integer getInventoryInStock() {
        return inventoryInStock;
    }

    public void setInventoryInStock(Integer inventoryInStock) {
        this.inventoryInStock = inventoryInStock;
    }

    @Basic
    @Column(name = "inventory_in_transit")
    public Integer getInventoryInTransit() {
        return inventoryInTransit;
    }

    public void setInventoryInTransit(Integer inventoryInTransit) {
        this.inventoryInTransit = inventoryInTransit;
    }

    @Basic
    @Column(name = "inventory_avaliable_qty")
    public Integer getInventoryAvaliableQty() {
        return inventoryAvaliableQty;
    }

    public void setInventoryAvaliableQty(Integer inventoryAvaliableQty) {
        this.inventoryAvaliableQty = inventoryAvaliableQty;
    }

    @Basic
    @Column(name = "inventory_moq")
    public Integer getInventoryMoq() {
        return inventoryMoq;
    }

    public void setInventoryMoq(Integer inventoryMoq) {
        this.inventoryMoq = inventoryMoq;
    }

    @Basic
    @Column(name = "inventory_reorder_point")
    public Integer getInventoryReorderPoint() {
        return inventoryReorderPoint;
    }

    public void setInventoryReorderPoint(Integer inventoryReorderPoint) {
        this.inventoryReorderPoint = inventoryReorderPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryEntity that = (InventoryEntity) o;
        return idInventory == that.idInventory &&
                Objects.equals(finishedInventoryCount, that.finishedInventoryCount) &&
                Objects.equals(inventoryInStock, that.inventoryInStock) &&
                Objects.equals(inventoryInTransit, that.inventoryInTransit) &&
                Objects.equals(inventoryAvaliableQty, that.inventoryAvaliableQty) &&
                Objects.equals(inventoryMoq, that.inventoryMoq) &&
                Objects.equals(inventoryReorderPoint, that.inventoryReorderPoint);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idInventory, finishedInventoryCount, inventoryInStock, inventoryInTransit, inventoryAvaliableQty, inventoryMoq, inventoryReorderPoint);
    }

    @ManyToOne
    @JoinColumn(name = "inventory_product", referencedColumnName = "id_products", nullable = false)
    public ProductsEntity getProductsByInventoryProduct() {
        return productsByInventoryProduct;
    }

    public void setProductsByInventoryProduct(ProductsEntity productsByInventoryProduct) {
        this.productsByInventoryProduct = productsByInventoryProduct;
    }

    @ManyToOne
    @JoinColumn(name = "inventory_product_pkging", referencedColumnName = "id_product_pkging", nullable = false)
    public ProductPkgingEntity getProductPkgingByInventoryProductPkging() {
        return productPkgingByInventoryProductPkging;
    }

    public void setProductPkgingByInventoryProductPkging(ProductPkgingEntity productPkgingByInventoryProductPkging) {
        this.productPkgingByInventoryProductPkging = productPkgingByInventoryProductPkging;
    }

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id_warehouse", nullable = false)
    public WarehouseEntity getWarehouseByWarehouseId() {
        return warehouseByWarehouseId;
    }

    public void setWarehouseByWarehouseId(WarehouseEntity warehouseByWarehouseId) {
        this.warehouseByWarehouseId = warehouseByWarehouseId;
    }
}
