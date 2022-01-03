package com.cytech.cytechback.wish;

import com.cytech.cytechback.option.Option;
import com.cytech.cytechback.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity()
@Table(name = "voeux")
@SequenceGenerator(name = "fiche_de_voeux_id_seq", sequenceName = "fiche_de_voeux_id_seq", allocationSize = 1)
public class Wish {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fiche_de_voeux_id_seq")
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="id_users", nullable = false, insertable = false, updatable = false)
    private User userOfWish;

    @Column(name = "id_users", nullable = false)
    private Long userId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "option", nullable = false)
    private Option option;

    @Column(name = "rang", nullable = false)
    private int rank;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserOfWish() {
        return userOfWish;
    }

    public void setUserOfWish(User userOfWish) {
        this.userOfWish = userOfWish;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
