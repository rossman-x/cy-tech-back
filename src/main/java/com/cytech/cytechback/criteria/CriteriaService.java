package com.cytech.cytechback.criteria;

import com.cytech.cytechback.option.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriteriaService implements ICriteriaService{

    @Autowired
    private CriteriaAssembler criteriaAssembler;

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Override
    public void createCriteriaByIdOptionAndContent(Long idOption, String content) {
        Criteria c = new Criteria();
        Option o = new Option();
        o.setId(idOption);
        c.setOption(o);
        c.setContent(content);
        this.criteriaRepository.save(c);
    }
}
