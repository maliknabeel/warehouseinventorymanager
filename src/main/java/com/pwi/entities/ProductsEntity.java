package com.pwi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "vtb_pwi")
public class ProductsEntity implements Serializable {
    private int idProducts;
    private String productName;
    private BrandsEntity brandsByProductBrand;
    private CountryEntity countryByProductCountry;
    private BrandProductTypeEntity brandProductTypeByProductType;
    private ProductMeasurementEntity productMeasurementByProductMeasurement;

    @Id
    @Column(name = "id_products")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(int idProducts) {
        this.idProducts = idProducts;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return idProducts == that.idProducts &&
                Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProducts, productName);
    }

    @ManyToOne
    @JoinColumn(name = "product_brand", referencedColumnName = "id_brands", nullable = false)
    public BrandsEntity getBrandsByProductBrand() {
        return brandsByProductBrand;
    }

    public void setBrandsByProductBrand(BrandsEntity brandsByProductBrand) {
        this.brandsByProductBrand = brandsByProductBrand;
    }

    @ManyToOne
    @JoinColumn(name = "product_country", referencedColumnName = "id_country", nullable = false)
    public CountryEntity getCountryByProductCountry() {
        return countryByProductCountry;
    }

    public void setCountryByProductCountry(CountryEntity countryByProductCountry) {
        this.countryByProductCountry = countryByProductCountry;
    }

    @ManyToOne
    @JoinColumn(name = "product_type", referencedColumnName = "id_product_type", nullable = false)
    public BrandProductTypeEntity getBrandProductTypeByProductType() {
        return brandProductTypeByProductType;
    }

    public void setBrandProductTypeByProductType(BrandProductTypeEntity brandProductTypeByProductType) {
        this.brandProductTypeByProductType = brandProductTypeByProductType;
    }

    @ManyToOne
    @JoinColumn(name = "product_measurement", referencedColumnName = "id_product_measurement", nullable = false)
    public ProductMeasurementEntity getProductMeasurementByProductMeasurement() {
        return productMeasurementByProductMeasurement;
    }

    public void setProductMeasurementByProductMeasurement(ProductMeasurementEntity productMeasurementByProductMeasurement) {
        this.productMeasurementByProductMeasurement = productMeasurementByProductMeasurement;
    }
}
