package com.cytech.cytechback.orientation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface OrientationRepository extends JpaRepository<Orientation, Long> {

    void deleteAllByUserOptionId(Long userId);
}
