package com.pwi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product_measurement", schema = "vtb_pwi")
public class ProductMeasurementEntity implements Serializable {
    private int idProductMeasurement;
    private String productMeasurementSize;
    private String productMeasurementDescription;
    private String productMeasurementUnit;

    @Id
    @Column(name = "id_product_measurement")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdProductMeasurement() {
        return idProductMeasurement;
    }

    public void setIdProductMeasurement(int idProductMeasurement) {
        this.idProductMeasurement = idProductMeasurement;
    }

    @Basic
    @Column(name = "product_measurement_size")
    public String getProductMeasurementSize() {
        return productMeasurementSize;
    }

    public void setProductMeasurementSize(String productMeasurementSize) {
        this.productMeasurementSize = productMeasurementSize;
    }

    @Basic
    @Column(name = "product_measurement_description")
    public String getProductMeasurementDescription() {
        return productMeasurementDescription;
    }

    public void setProductMeasurementDescription(String productMeasurementDescription) {
        this.productMeasurementDescription = productMeasurementDescription;
    }

    @Basic
    @Column(name = "product_measurement_unit")
    public String getProductMeasurementUnit() {
        return productMeasurementUnit;
    }

    public void setProductMeasurementUnit(String productMeasurementUnit) {
        this.productMeasurementUnit = productMeasurementUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductMeasurementEntity that = (ProductMeasurementEntity) o;
        return idProductMeasurement == that.idProductMeasurement &&
                Objects.equals(productMeasurementSize, that.productMeasurementSize) &&
                Objects.equals(productMeasurementDescription, that.productMeasurementDescription) &&
                Objects.equals(productMeasurementUnit, that.productMeasurementUnit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProductMeasurement, productMeasurementSize, productMeasurementDescription, productMeasurementUnit);
    }
}
