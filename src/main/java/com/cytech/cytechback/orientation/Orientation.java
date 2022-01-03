package com.cytech.cytechback.orientation;

import com.cytech.cytechback.option.Option;
import com.cytech.cytechback.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "orientation")
@SequenceGenerator(name = "orientation_id_seq", sequenceName = "orientation_id_seq", allocationSize = 1)
public class Orientation {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orientation_id_seq")
    private Long id;

    @Column(name = "remarque", length = 500, nullable = false)
    private String remarque;

    @ManyToOne
    @JoinColumn(name = "option_retenu", nullable = false)
    private Option option;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "id_users", nullable = false)
    private User userOption;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public User getUserOption() {
        return userOption;
    }

    public void setUserOption(User userOption) {
        this.userOption = userOption;
    }
}
