package com.pwi.entities;

import javax.persistence.*;

@Entity
@SqlResultSetMapping(name="brandProductsCountryMapping",
        entities = {
                @EntityResult(entityClass = BrandProductsEntity.class,
                        fields = {
                                @FieldResult(name = "productId", column = "productId"),
                                @FieldResult(name = "productName", column = "productName"),
                                @FieldResult(name = "brandName", column = "brandName"),
                                @FieldResult(name = "productMeasurement", column = "productMeasurement"),
                                @FieldResult(name = "countryName", column = "countryName"),
                                @FieldResult(name = "categotyName", column = "categotyName"),
                                @FieldResult(name = "inventoryInTransit", column = "inventoryInTransit"),
                        })
        })

@NamedNativeQuery(name="brandProductsReport",
        query = "select p.id_products as productId, p.product_name as productName, b.brand_name as brandName, m.product_measurement_size as productMeasurement, c.country_name as countryName , ct.category_name as categotyName\n" +
                "from products p, brands b, country c, categories ct, product_measurements pm, measurement m\n" +
                "where p.product_country = c.id_country\n" +
                "and p.product_brand = b.id_brands\n" +
                "and b.brand_category = ct.id_category\n" +
                "and p.id_products = pm.product_id\n" +
                "and pm.measurement_id = m.id_product_measurement\n" +
                "and p.product_brand = ?",
        resultClass = BrandProductsEntity.class
)
public class BrandProductsEntity {

    @Id
    private int productId;
    private String productName;
    private String brandName;
    private String productMeasurement;
    private String countryName;
    private String categotyName;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductMeasurement() {
        return productMeasurement;
    }

    public void setProductMeasurement(String productMeasurement) {
        this.productMeasurement = productMeasurement;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCategotyName() {
        return categotyName;
    }

    public void setCategotyName(String categotyName) {
        this.categotyName = categotyName;
    }
}
