package com.pwi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "brand_product_type", schema = "vtb_pwi")
public class BrandProductTypeEntity implements Serializable {
    private int idProductType;
    private String productType;
    private String productTypeDescription;

    @Id
    @Column(name = "id_product_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(int idProductType) {
        this.idProductType = idProductType;
    }

    @Basic
    @Column(name = "product_type")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "product_type_description")
    public String getProductTypeDescription() {
        return productTypeDescription;
    }

    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandProductTypeEntity that = (BrandProductTypeEntity) o;
        return idProductType == that.idProductType &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(productTypeDescription, that.productTypeDescription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProductType, productType, productTypeDescription);
    }
}
