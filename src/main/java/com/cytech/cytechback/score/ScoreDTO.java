package com.cytech.cytechback.score;

import com.cytech.cytechback.common.SimpleDto;
import com.cytech.cytechback.subject.Subject;
import com.cytech.cytechback.subject.SubjectDTO;

public class ScoreDTO implements SimpleDto {
    private int score;
    private int scoreMax;
    private int userId;
    private int subjectId;
    private SubjectDTO subject;

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
