package ru.bellintegrator.javaproject.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import java.util.Set;

@Entity
@Table(name = "Country")
public class Country {

    @Id
    @Column(name = "code")
    private int code;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Country", cascade = CascadeType.ALL)
    @JoinColumn(name = "citizenship_code")
    private Set<User> users;

    public int getCountryCode() {
        return code;
    }

    public void setCountryCode(int code) {
        this.code = code;
    }

    public String getCountryName() {
        return name;
    }

    public void setCountryName(String name) {
        this.name = name;
    }

    public Set<User> getCountryUsers() {
        return users;
    }

    public void setCountryUsers(Set<User> users) {
        this.users = users;
    }
}
