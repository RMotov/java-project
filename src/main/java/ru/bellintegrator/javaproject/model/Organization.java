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
import javax.persistence.JoinColumn;
import java.util.Set;

@Entity
@Table(name = "Organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "full_name", nullable = false)
    private String full_name;

    @Column(name = "inn", nullable = false)
    private int inn;

    @Column(name = "kpp", nullable = false)
    private int kpp;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_active", nullable = false)
    private int is_active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Organization", cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
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
        return full_name;
    }

    public void setOrgFullName(String full_name) {
        this.full_name = full_name;
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
        return is_active;
    }

    public void setOrgIsActive(int is_active) {
        this.is_active = is_active;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }
}
