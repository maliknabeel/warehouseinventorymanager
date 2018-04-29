package com.pwi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Entity
@Table(name = "warehouse", schema = "vtb_pwi")
public class WarehouseEntity implements Serializable {
    private int idWarehouse;
    private String warehouseName;
    private String warehouseAddress;
    private CountryEntity countryByWarehouseCountry;

    @Id
    @Column(name = "id_warehouse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    @Basic
    @Column(name = "warehouse_name")
    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    @Basic
    @Column(name = "warehouse_address")
    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseEntity that = (WarehouseEntity) o;
        return idWarehouse == that.idWarehouse &&
                Objects.equals(warehouseName, that.warehouseName) &&
                Objects.equals(warehouseAddress, that.warehouseAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idWarehouse, warehouseName, warehouseAddress);
    }

    @ManyToOne
    @JoinColumn(name = "warehouse_country", referencedColumnName = "id_country", nullable = false)
    public CountryEntity getCountryByWarehouseCountry() {
        return countryByWarehouseCountry;
    }

    public void setCountryByWarehouseCountry(CountryEntity countryByWarehouseCountry) {
        this.countryByWarehouseCountry = countryByWarehouseCountry;
    }
}
