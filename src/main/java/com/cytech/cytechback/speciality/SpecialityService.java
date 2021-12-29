package com.cytech.cytechback.speciality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityService implements ISpecialityService{

    @Autowired
    private SpecialityAssembler specialityAssembler;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public List<SpecialityDTO> getSpecialities() {
        List<Speciality> specialities = specialityRepository.findAll();
        List<SpecialityDTO> specialitiesDto = specialityAssembler.toDtoList(specialities);
        return specialitiesDto;
    }
}
