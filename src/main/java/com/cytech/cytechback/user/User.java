package com.cytech.cytechback.user;

import com.cytech.cytechback.speciality.Speciality;
import com.cytech.cytechback.subject.Subject;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity()
@Table(name = "users")
@SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
public class User {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    private Long id;

    @Column(name = "Prenom", length = 50, nullable = false)
    private String firstName;

    @Column(name = "Nom", length = 50, nullable = false)
    private String lastName;

    @Column(name = "Mot_de_passe", length = 50, nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "Date_de_naissance")
    private Date birthdayDate;

    @Column(name = "Email", length = 50, nullable = false)
    private String emailAddress;

    @Column(name = "Adresse", length = 50, nullable = false)
    private String Address;

    @Column(name = "Statut", length = 20, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name="Id_Specialite", nullable=false)
    private Speciality speciality;

    @ManyToMany
    @JoinTable(
            name = "contenir",
            joinColumns = @JoinColumn(name = "Id"),
            inverseJoinColumns = @JoinColumn(name = "Id_specialite"))
    private Set<Subject> subjects;

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
