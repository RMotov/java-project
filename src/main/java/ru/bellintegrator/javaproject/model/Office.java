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
     * Идентификатор организации
     */
    @Column(name = "organization_id", nullable = false)
    private Long organizationId;

    /**
     * Наименование офиса
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Адрес офиса
     */
    @Column(name = "address", nullable = false)
    private String address;

    /**
     * Телефон офиса
     */
    @Column(name = "phone", nullable = false)
    private String phone;

    /**
     * Признак активности: 0 = не активен; 1 = активен
     */
    @Column(name = "is_active", nullable = false)
    private int isActive;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id", insertable = false, updatable = false)
    private Organization organization;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "office", cascade = CascadeType.ALL)
    private Set<User> users;

    public Long getOfficeId() {
        return id;
    }

    public Long getOfficeOrganizationId() {
        return organizationId;
    }

    public void setOfficeOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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
        return isActive;
    }

    public void setOfficeIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Organization getOfficeOrganization() {
        return organization;
    }

    public void setOfficeOrganization(Organization organization) {
        this.organization = organization;
    }
}
