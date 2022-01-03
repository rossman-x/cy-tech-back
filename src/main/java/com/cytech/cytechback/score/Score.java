package com.cytech.cytechback.score;

import com.cytech.cytechback.subject.Subject;
import com.cytech.cytechback.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "note")
@SequenceGenerator(name = "note_id_seq", sequenceName = "note_id_seq", allocationSize = 1)
public class Score {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_id_seq")
    private Long id;

    @Column(name = "note", nullable = false)
    private int score;

    @Column(name = "note_max", nullable = false)
    private int scoreMax;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_users", nullable = false)
    private User scoreUser;

    @ManyToOne
    @JoinColumn(name = "id_matiere", nullable = false)
    @JsonIgnore
    private Subject scoreSubject;

    public User getScoreUser() {
        return scoreUser;
    }

    public void setScoreUser(User scoreUser) {
        this.scoreUser = scoreUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScoreMax() {
        return scoreMax;
    }

    public void setScoreMax(int scoreMax) {
        this.scoreMax = scoreMax;
    }

    public Subject getScoreSubject() {
        return scoreSubject;
    }

    public void setScoreSubject(Subject scoreSubject) {
        this.scoreSubject = scoreSubject;
    }
}
