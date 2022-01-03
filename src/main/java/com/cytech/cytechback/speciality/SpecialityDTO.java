package com.cytech.cytechback.speciality;

import com.cytech.cytechback.common.SimpleDto;
import com.cytech.cytechback.subject.Subject;

import java.util.Set;

public class SpecialityDTO implements SimpleDto {

    private Long id;
    private String name;
    private Set<Subject> subjectSet;

    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
