package com.cytech.cytechback.score;

import java.util.List;

public interface IScoreService {

    void createScoreByScoreDto(ScoreDTO dto);

    List<ScoreDTO> getScoresByUserId(int userId);
}
