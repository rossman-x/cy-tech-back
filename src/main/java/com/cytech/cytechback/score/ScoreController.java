package com.cytech.cytechback.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController implements IScoreController{

    @Autowired
    private ScoreService scoreService;


    @PostMapping(path = "create")
    @Override
    public ResponseEntity<Void> createScore(ScoreDTO scoreDTO) {
        this.scoreService.createScoreByScoreDto(scoreDTO);
        return null;
    }

    @GetMapping(path = "list")
    @Override
    public ResponseEntity<List<ScoreDTO>> getScoresByUserId(int userId) {
        return ResponseEntity.ok(this.scoreService.getScoresByUserId(userId));
    }

}
