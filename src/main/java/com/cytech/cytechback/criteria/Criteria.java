package com.cytech.cytechback.criteria;

import com.cytech.cytechback.option.Option;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "criteres_orientation")
@SequenceGenerator(name = "criteres_orientation_id_seq", sequenceName = "criteres_orientation_id_seq", allocationSize = 1)
public class Criteria {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "criteres_orientation_id_seq")
    private Long id;

    @Column(name = "contenu", length = 50, nullable = false)
    private String content;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_options", nullable = false)
    private Option option;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
