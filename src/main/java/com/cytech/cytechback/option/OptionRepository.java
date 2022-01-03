package com.cytech.cytechback.option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface OptionRepository extends JpaRepository<Option, Long> {

    @Query("SELECT o FROM Option o INNER JOIN o.specialitySet s WHERE s.id = ?1")
    Set<Option> selectAllBySpecialityId(Long specialityId);
}
