package ru.bellintegrator.javaproject.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import java.util.GregorianCalendar;

@Entity
@Table(name = "User")
public class User {

    /**
     * Уникальный идентификатор
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Идентификатор офиса
     */
    @Column(name = "office_id", nullable = false)
    private Long officeId;

    /**
     * Имя
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "second_name")
    private String secondName;

    /**
     * Отчество
     */
    @Column(name = "middle_name")
    private String middleName;

    /**
     * Позиция пользователя
     */
    @Column(name = "position", nullable = false)
    private String position;

    /**
     * Телефон пользователя
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Код документа удостоверяющего личность
     */
    @Column(name = "doc_code", nullable = false)
    private String docCode;

    /**
     * Номер документа удостоверяющего личность
     */
    @Column(name = "doc_number")
    private int docNumber;

    /**
     * Дата выдачи документа удостоверяющего личность
     */
    @Column(name = "doc_date")
    private GregorianCalendar docDate; //???

    /**
     * Код гражданства
     */
    @Column(name = "citizenship_code", nullable = false)
    private int citizenshipCode;

    /**
     * Признак идентификации: 0 = не активен; 1 = активен.
     */
    @Column(name = "is_identified", nullable = false)
    private int isIdentified;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id", insertable = false, updatable = false)
    private Office office;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "citizenship_code", insertable = false, updatable = false)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_code", insertable = false, updatable = false)
    private Doc doc;

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long id) {
        this.id = id;
    }

    public void setUserOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public Long getUserOfficeId() {
        return officeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setUserSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUserMiddleName() {
        return middleName;
    }

    public void setUserMiddleName(String middleName) {
        this.middleName = middleName;
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
        return docCode;
    }

    public void setUserDocCode(String docCode) {
        this.docCode = docCode;
    }

    public int getUserDocNumber() {
        return docNumber;
    }

    public void setDocNumber(int docNumber) {
        this.docNumber = docNumber;
    }

    public GregorianCalendar getUserDocDate() {
        return docDate;
    }

    public void setUserDocDate(GregorianCalendar docDate) {
        this.docDate = docDate;
    }

    public int getUserCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(int citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public int getUserIsIdentified() {
        return isIdentified;
    }

    public void setUserIsIdentified(int isIdentified) {
        this.isIdentified = isIdentified;
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
