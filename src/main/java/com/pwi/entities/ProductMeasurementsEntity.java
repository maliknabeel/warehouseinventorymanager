package com.pwi.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_measurements", schema = "vtb_pwi")
public class ProductMeasurementsEntity {
    private int idproductMeasurements;
    private ProductsEntity productsByProductId;
    private MeasurementEntity measurementByMeasurementId;

    @Id
    @Column(name = "idproduct_measurements")
    public int getIdproductMeasurements() {
        return idproductMeasurements;
    }

    public void setIdproductMeasurements(int idproductMeasurements) {
        this.idproductMeasurements = idproductMeasurements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductMeasurementsEntity that = (ProductMeasurementsEntity) o;
        return idproductMeasurements == that.idproductMeasurements;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idproductMeasurements);
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id_products", nullable = false)
    public ProductsEntity getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(ProductsEntity productsByProductId) {
        this.productsByProductId = productsByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "measurement_id", referencedColumnName = "id_product_measurement", nullable = false)
    public MeasurementEntity getMeasurementByMeasurementId() {
        return measurementByMeasurementId;
    }

    public void setMeasurementByMeasurementId(MeasurementEntity measurementByMeasurementId) {
        this.measurementByMeasurementId = measurementByMeasurementId;
    }
}
