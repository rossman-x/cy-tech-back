package com.cytech.cytechback.criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/criterias")
public class CriteriaController implements ICriteriaController {

    @Autowired
    private CriteriaService criteriaService;

    @Override
    @PostMapping(path = "/create")
    public ResponseEntity<Void> createCriterias(CriteriasRequestBody criteriasRequestBody) {
        this.criteriaService.createCriteriaByIdOptionAndContent(Long.valueOf(criteriasRequestBody.getOption()), criteriasRequestBody.getCriteria1());
        this.criteriaService.createCriteriaByIdOptionAndContent(Long.valueOf(criteriasRequestBody.getOption()), criteriasRequestBody.getCriteria2());
        return null;
    }
}
