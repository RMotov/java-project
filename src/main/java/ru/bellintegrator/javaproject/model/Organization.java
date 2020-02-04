package ru.bellintegrator.javaproject.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.util.Set;

@Entity
@Table(name = "Organization")
public class Organization {

    /**
    * Уникальный идентификатор
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Наименование организации
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Полное наименование организации
     */
    @Column(name = "full_name", nullable = false)
    private String fullName;

    /**
     * ИНН
     */
    @Column(name = "inn", nullable = false)
    private int inn;

    /**
     * КПП
     */
    @Column(name = "kpp", nullable = false)
    private int kpp;

    /**
     * Адрес организации
     */
    @Column(name = "address", nullable = false)
    private String address;

    /**
     * Телефон организации
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Признак активности: 0 = не активен; 1 = активен.
     */
    @Column(name = "is_active", nullable = false)
    private int isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization", cascade = CascadeType.ALL)
    private Set<Office> offices;

    public Long getOrgId() {
        return id;
    }

    public String getOrgName() {
        return name;
    }

    public void setOrgName(String name) {
        this.name = name;
    }

    public String getOrgFullName() {
        return fullName;
    }

    public void setOrgFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getOrgInn() {
        return inn;
    }

    public void setOrgInn(int inn) {
        this.inn = inn;
    }

    public int getOrgKpp() {
        return kpp;
    }

    public void setOrgKpp(int kpp) {
        this.kpp = kpp;
    }

    public String getOrgAddress() {
        return address;
    }

    public void setOrgAddress(String address) {
        this.address = address;
    }

    public String getOrgPhone() {
        return phone;
    }

    public void setOrgPhone(String phone) {
        this.phone = phone;
    }

    public int getOrgIsActive() {
        return isActive;
    }

    public void setOrgIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }
}
