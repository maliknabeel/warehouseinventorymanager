package com.pwi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Entity
@Table(name = "offices", schema = "vtb_pwi")
public class OfficesEntity implements Serializable {
    private int idOffices;
    private String officeName;
    private String officeAddress;
    private CountryEntity countryByOfficesCountry;

    @Id
    @Column(name = "id_offices")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdOffices() {
        return idOffices;
    }

    public void setIdOffices(int idOffices) {
        this.idOffices = idOffices;
    }

    @Basic
    @Column(name = "office_name")
    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    @Basic
    @Column(name = "office_address")
    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficesEntity that = (OfficesEntity) o;
        return idOffices == that.idOffices &&
                Objects.equals(officeName, that.officeName) &&
                Objects.equals(officeAddress, that.officeAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idOffices, officeName, officeAddress);
    }

    @ManyToOne
    @JoinColumn(name = "offices_country", referencedColumnName = "id_country")
    public CountryEntity getCountryByOfficesCountry() {
        return countryByOfficesCountry;
    }

    public void setCountryByOfficesCountry(CountryEntity countryByOfficesCountry) {
        this.countryByOfficesCountry = countryByOfficesCountry;
    }
}
