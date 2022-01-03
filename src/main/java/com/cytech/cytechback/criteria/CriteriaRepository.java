package com.cytech.cytechback.criteria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CriteriaRepository extends JpaRepository<Criteria, Long> {

}
