package ru.bellintegrator.javaproject.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.util.GregorianCalendar;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @Column(name = "office_id", nullable = false)
    private Long office_id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "second_name")
    private String second_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "phone")
    private String phone;

    @Column(name = "doc_code", nullable = false)
    private String doc_code;

    @Column(name = "doc_number")
    private int doc_number;

    @Column(name = "doc_date")
    private GregorianCalendar doc_date; //???

    @Column(name = "citizenship_code", nullable = false)
    private int citizenship_code;

    @Column(name = "is_identified", nullable = false)
    private int is_identified;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Office office;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Doc doc;

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long id) {
        this.id = id;
    }

    public void setUserOfficeId(Long office_id) {
        this.office_id = office_id;
    }

    public Long getUserOfficeId() {
        return office_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getSecondName() {
        return second_name;
    }

    public void setUserSecondName(String second_name) {
        this.second_name = second_name;
    }

    public String getUserMiddleName() {
        return middle_name;
    }

    public void setUserMiddleName(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getUserPosition() {
        return position;
    }

    public void setUserPosition(String position) {
        this.position = position;
    }

    public String getUserPhone() {
        return phone;
    }

    public void setUserPhone(String phone) {
        this.phone = phone;
    }

    public String getUserDocCode() {
        return doc_code;
    }

    public void setUserDocCode(String doc_code) {
        this.doc_code = doc_code;
    }

    public int getUserDocNumber() {
        return doc_number;
    }

    public void setDocNumber(int doc_number) {
        this.doc_number = doc_number;
    }

    public GregorianCalendar getUserDocDate() {
        return doc_date;
    }

    public void setUserDocDate(GregorianCalendar doc_date) {
        this.doc_date = doc_date;
    }

    public int getUserCitizenshipCode() {
        return citizenship_code;
    }

    public void setCitizenshipCode(int citizenship_code) {
        this.citizenship_code = citizenship_code;
    }

    public int getUserIsIdentified() {
        return is_identified;
    }

    public void setUserIsIdentified(int is_identified) {
        this.is_identified = is_identified;
    }

    public Office getUserOffice() {
        return office;
    }

    public void setUserOffice(Office office) {
        this.office = office;
    }

    public Country getUserCountry() {
        return country;
    }

    public void setUserCountry(Country country) {
        this.country = country;
    }

    public Doc getUserDoc() {
        return doc;
    }

    public void setUserDoc(Doc doc) {
        this.doc = doc;
    }
}
