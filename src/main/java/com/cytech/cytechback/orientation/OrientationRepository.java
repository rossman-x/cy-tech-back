package com.cytech.cytechback.orientation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface OrientationRepository extends JpaRepository<Orientation, Long> {
}
