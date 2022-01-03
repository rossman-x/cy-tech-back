package com.cytech.cytechback.speciality;

import com.cytech.cytechback.common.SimpleAssembler;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialityAssembler implements SimpleAssembler<SpecialityDTO, Speciality> {
    @Override
    public SpecialityDTO toDto(Speciality speciality) {
        SpecialityDTO dto = new SpecialityDTO();
        dto.setId(speciality.getId());
        dto.setName(speciality.getName());
        dto.setSubjectSet(speciality.getSubjects());
        return dto;
    }

    @Override
    public Speciality fromDto(SpecialityDTO dto) {
        Speciality speciality = new Speciality();
        speciality.setName(dto.getName());
        return speciality;
    }

    @Override
    public List<SpecialityDTO> toDtoList(List<Speciality> documentList) {
        if(documentList != null && !documentList.isEmpty())
            return documentList.stream().map(this::toDto).collect(Collectors.toList());
        return Collections.emptyList();
    }

    @Override
    public List<Speciality> fromDtoList(List<SpecialityDTO> dtoList) {
        if(dtoList != null && !dtoList.isEmpty())
            return dtoList.stream().map(this::fromDto).collect(Collectors.toList());
        return Collections.emptyList();
    }
}
