package com.cytech.cytechback.speciality;


import com.cytech.cytechback.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity()
@Table(name = "specialite")
@SequenceGenerator(name = "specs_id_seq", sequenceName = "specs_id_seq", allocationSize = 1)
public class Speciality {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specs_id_seq")
    private Long id;

    @Column(name = "Nom", length = 50, nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "speciality")
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
