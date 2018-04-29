package com.pwi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Entity
@Table(name = "brands", schema = "vtb_pwi")
@Transactional
public class BrandsEntity implements Serializable {
    private int idBrands;
    private String brandName;
    private String brandDescription;
    private CountryEntity countryByBrandCountry;
    private CategoriesEntity categoriesByBrandCategory;
    private Collection<ProductsEntity> productsByIdBrands;

    @Id
    @Column(name = "id_brands")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdBrands() {
        return idBrands;
    }

    public void setIdBrands(int idBrands) {
        this.idBrands = idBrands;
    }

    @Basic
    @Column(name = "brand_name")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Basic
    @Column(name = "brand_description")
    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandsEntity that = (BrandsEntity) o;
        return idBrands == that.idBrands &&
                Objects.equals(brandName, that.brandName) &&
                Objects.equals(brandDescription, that.brandDescription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBrands, brandName, brandDescription);
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_country", referencedColumnName = "id_country", nullable = false)
    public CountryEntity getCountryByBrandCountry() {
        return countryByBrandCountry;
    }

    public void setCountryByBrandCountry(CountryEntity countryByBrandCountry) {
        this.countryByBrandCountry = countryByBrandCountry;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_category", referencedColumnName = "id_category", nullable = false)
    public CategoriesEntity getCategoriesByBrandCategory() {
        return categoriesByBrandCategory;
    }

    public void setCategoriesByBrandCategory(CategoriesEntity categoriesByBrandCategory) {
        this.categoriesByBrandCategory = categoriesByBrandCategory;
    }

    @OneToMany(mappedBy = "brandsByProductBrand", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Collection<ProductsEntity> getProductsByIdBrands() {
        return productsByIdBrands;
    }

    public void setProductsByIdBrands(Collection<ProductsEntity> productsByIdBrands) {
        this.productsByIdBrands = productsByIdBrands;
    }
}
