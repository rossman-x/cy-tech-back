package com.cytech.cytechback.subject;

import com.cytech.cytechback.score.Score;
import com.cytech.cytechback.speciality.Speciality;
import com.cytech.cytechback.ue.UE;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity()
@Table(name = "matieres")
@SequenceGenerator(name = "matieres_id_seq", sequenceName = "matieres_id_seq", allocationSize = 1)
public class Subject {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matieres_id_seq")
    private Long id;

    @Column(name = "Nom", length = 50, nullable = false)
    private String name;

    @Column(name = "coef", nullable = false)
    private int coef;

    @JsonIgnore
    @ManyToMany(mappedBy = "subjects")
    private Set<Speciality> specialities;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_uniteenseignement", nullable = false)
    private UE uniteEnseignement;

    @JsonIgnore
    @OneToMany(mappedBy = "scoreSubject")
    private Set<Score> scores;

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    public UE getUe() {
        return uniteEnseignement;
    }

    public void setUe(UE ue) {
        this.uniteEnseignement = ue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
