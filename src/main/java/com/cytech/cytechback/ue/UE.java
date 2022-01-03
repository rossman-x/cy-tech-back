package com.cytech.cytechback.ue;

import javax.persistence.*;

@Entity
@Table(name = "uniteenseignement")
@SequenceGenerator(name = "unite_enseignement_id_seq", sequenceName = "unite_enseignement_id_seq", allocationSize = 1)
public class UE {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unite_enseignement_id_seq")
    private Long id;

    @Column(name = "nom", nullable = false)
    private String name;

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
