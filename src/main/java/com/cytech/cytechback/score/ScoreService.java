package com.cytech.cytechback.score;

import com.cytech.cytechback.subject.Subject;
import com.cytech.cytechback.subject.SubjectAssembler;
import com.cytech.cytechback.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ScoreService implements IScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private SubjectAssembler subjectAssembler;

    @Override
    public void createScoreByScoreDto(ScoreDTO dto) {
        Score s = new Score();
        s.setScore(dto.getScore());
        s.setScoreMax(dto.getScoreMax());
        User u = new User();
        u.setId(Long.valueOf(dto.getUserId()));
        s.setScoreUser(u);
        Subject subject = new Subject();
        subject.setId(Long.valueOf(dto.getSubjectId()));
        s.setScoreSubject(subject);

        this.scoreRepository.save(s);
    }

    public List<ScoreDTO> getScoresByUserId(int userId) {
        //Set<Score> scores = this.scoreRepository.findAllByScoreUserId(Long.valueOf(userId));
        List<Score> scores = this.scoreRepository.findAll();
        List<ScoreDTO> scoreDTOSet = scores.stream().map(score -> {
            System.out.println("IDDDD " + score.getScoreUser().getId());
            ScoreDTO dto = new ScoreDTO();
            dto.setScore(score.getScore());
            dto.setScoreMax(score.getScoreMax());
            dto.setSubject(this.subjectAssembler.toDto(score.getScoreSubject()));
            dto.setSubjectId(score.getScoreSubject().getId().intValue());
            dto.setUserId(score.getScoreUser().getId().intValue());
            return dto;
        }).collect(Collectors.toList());
        return scoreDTOSet;
    }
}
