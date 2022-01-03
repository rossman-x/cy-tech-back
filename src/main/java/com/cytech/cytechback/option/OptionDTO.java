package com.cytech.cytechback.option;

import com.cytech.cytechback.common.SimpleDto;
import com.cytech.cytechback.speciality.Speciality;

import java.util.List;
import java.util.Set;

public class OptionDTO implements SimpleDto {

    private Long id;

    private String name;

    private Set<Speciality> specialities;

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

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
