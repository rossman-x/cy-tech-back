package com.cytech.cytechback.score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public interface ScoreRepository extends JpaRepository<Score, Long> {

    Set<Score> findAllByScoreUserId(Long id);
}
