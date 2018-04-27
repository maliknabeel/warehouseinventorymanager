package com.pwi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product_pkging", schema = "vtb_pwi")
public class ProductPkgingEntity implements Serializable {
    private int idProductPkging;
    private ProductsEntity productsByProductId;
    private PkgingInformationEntity pkgingInformationByPkgingId;

    @Id
    @Column(name = "id_product_pkging")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdProductPkging() {
        return idProductPkging;
    }

    public void setIdProductPkging(int idProductPkging) {
        this.idProductPkging = idProductPkging;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPkgingEntity that = (ProductPkgingEntity) o;
        return idProductPkging == that.idProductPkging;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProductPkging);
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id_products")
    public ProductsEntity getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(ProductsEntity productsByProductId) {
        this.productsByProductId = productsByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "pkging_id", referencedColumnName = "id_pkging_info")
    public PkgingInformationEntity getPkgingInformationByPkgingId() {
        return pkgingInformationByPkgingId;
    }

    public void setPkgingInformationByPkgingId(PkgingInformationEntity pkgingInformationByPkgingId) {
        this.pkgingInformationByPkgingId = pkgingInformationByPkgingId;
    }
}
