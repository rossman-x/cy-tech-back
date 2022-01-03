package com.cytech.cytechback.option;

import com.cytech.cytechback.criteria.Criteria;
import com.cytech.cytechback.speciality.Speciality;
import com.cytech.cytechback.wish.Wish;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity()
@Table(name = "options")
@SequenceGenerator(name = "options_id_seq", sequenceName = "options_id_seq", allocationSize = 1)
public class Option {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "options_id_seq")
    private Long id;

    @Column(name = "nom", length = 50, nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "optionsOfSpeciality")
    Set<Speciality> specialitySet;

    @JsonIgnore
    @OneToMany(mappedBy = "option")
    Set<Criteria> criterias;

    @OneToMany(mappedBy = "option")
    Set<Wish> wishes;

    public Set<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(Set<Wish> wishes) {
        this.wishes = wishes;
    }

    public Set<Criteria> getCriterias() {
        return criterias;
    }

    public void setCriterias(Set<Criteria> criterias) {
        this.criterias = criterias;
    }

    public Set<Speciality> getSpecialitySet() {
        return specialitySet;
    }

    public void setSpecialitySet(Set<Speciality> specialitySet) {
        this.specialitySet = specialitySet;
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
}
