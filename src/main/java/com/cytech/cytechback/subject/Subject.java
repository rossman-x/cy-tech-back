package com.cytech.cytechback.subject;

import com.cytech.cytechback.user.User;
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

    @JsonIgnore
    @ManyToMany(mappedBy = "subjects")
    Set<User> users;

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
