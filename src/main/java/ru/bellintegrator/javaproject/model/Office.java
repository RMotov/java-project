package ru.bellintegrator.javaproject.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Table(name = "Office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "organization_id", nullable = false)
    private Long organization_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "is_active", nullable = false)
    private int is_active;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Organization organization;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Office", cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id")
    private Set<User> users;

    public Long getOfficeId() {
        return id;
    }

    public Long getOfficeOrganizationId() {
        return organization_id;
    }

    public void setOfficeOrganizationId(Long organization_id) {
        this.organization_id = organization_id;
    }

    public String getOfficeName() {
        return name;
    }

    public void setOfficeName(String name) {
        this.name = name;
    }

    public String getOfficeAddress() {
        return address;
    }

    public void setOfficeAddress(String address) {
        this.address = address;
    }

    public String getOfficePhone() {
        return phone;
    }

    public void setOfficePhone(String phone) {
        this.phone = phone;
    }

    public int getOfficeIsActive() {
        return is_active;
    }

    public void setOfficeIsActive(int is_active) {
        this.is_active = is_active;
    }

    public Organization getOfficeOrganization() {
        return organization;
    }

    public void setOfficeOrganization(Organization organization) {
        this.organization = organization;
    }
}
