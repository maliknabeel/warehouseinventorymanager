package com.pwi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pkging_information", schema = "vtb_pwi")
public class PkgingInformationEntity implements Serializable {
    private int idPkgingInfo;
    private int pkgingSize;
    private String pkgingUnit;

    @Id
    @Column(name = "id_pkging_info")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdPkgingInfo() {
        return idPkgingInfo;
    }

    public void setIdPkgingInfo(int idPkgingInfo) {
        this.idPkgingInfo = idPkgingInfo;
    }

    @Basic
    @Column(name = "pkging_size")
    public int getPkgingSize() {
        return pkgingSize;
    }

    public void setPkgingSize(int pkgingSize) {
        this.pkgingSize = pkgingSize;
    }

    @Basic
    @Column(name = "pkging_unit")
    public String getPkgingUnit() {
        return pkgingUnit;
    }

    public void setPkgingUnit(String pkgingUnit) {
        this.pkgingUnit = pkgingUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PkgingInformationEntity that = (PkgingInformationEntity) o;
        return idPkgingInfo == that.idPkgingInfo &&
                pkgingSize == that.pkgingSize &&
                Objects.equals(pkgingUnit, that.pkgingUnit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPkgingInfo, pkgingSize, pkgingUnit);
    }
}
