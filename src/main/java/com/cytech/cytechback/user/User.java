package com.cytech.cytechback.user;

import com.cytech.cytechback.orientation.Orientation;
import com.cytech.cytechback.score.Score;
import com.cytech.cytechback.speciality.Speciality;
import com.cytech.cytechback.subject.Subject;
import com.cytech.cytechback.wish.Wish;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity()
@Table(name = "users")
@SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
public class User implements Comparable<User> {

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

    @Column(name = "heures_absence", nullable = false)
    private int hoursAbsent;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Id_Specialite", nullable = false)
    private Speciality speciality;

    @OneToMany(mappedBy = "userOfWish")
    @JsonIgnore
    private Set<Wish> wishSet;

    @OneToMany(mappedBy = "scoreUser")
    @JsonIgnore
    private Set<Score> scores;

    @OneToOne(mappedBy = "userOption")
    private Orientation orientation;

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    public int getHoursAbsent() {
        return hoursAbsent;
    }

    public void setHoursAbsent(int hoursAbsent) {
        this.hoursAbsent = hoursAbsent;
    }

    public Set<Wish> getWishSet() {
        return wishSet;
    }

    public void setWishSet(Set<Wish> wishSet) {
        this.wishSet = wishSet;
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

    public double getAverage(int subjectId) {
        Set<Score> scores = this.getScores();
        double sum = 0;
        double sumMax = 0;
        for (Score score : scores) {
            Subject subject = score.getScoreSubject();
            if (subjectId == -1 || subject.getId() == subjectId) {
                int coef = subject.getCoef();
                sum += coef * score.getScore();
                sumMax += coef * score.getScoreMax();
            }
        }
        return sumMax == 0 ? 0 : sum  / sumMax;
    }

    @Override
    public int compareTo(User o) {
        return this.getHoursAbsent() - o.getHoursAbsent();
    }
}
