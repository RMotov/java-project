package ru.bellintegrator.javaproject.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import java.util.Set;

@Entity
@Table(name = "Doc")
public class Doc {

    @Id
    @Column(name = "code")
    private int code;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Doc", cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_code")
    private Set<User> users;

    public int getDocCode() {
        return code;
    }

    public void setDocCode(int code) {
        this.code = code;
    }

    public String getDocName() {
        return name;
    }

    public void setDocName(String name) {
        this.name = name;
    }

    public Set<User> getDocUsers() {
        return users;
    }

    public void setDocUsers(Set<User> users) {
        this.users = users;
    }
}
