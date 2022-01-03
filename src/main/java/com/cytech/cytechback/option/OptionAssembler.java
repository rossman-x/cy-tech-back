package com.cytech.cytechback.option;

import com.cytech.cytechback.common.SimpleAssembler;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionAssembler implements SimpleAssembler<OptionDTO, Option> {

    @Override
    public OptionDTO toDto(Option o) {
        OptionDTO dto = new OptionDTO();
        dto.setId(o.getId());
        dto.setName(o.getName());
        dto.setSpecialities(o.getSpecialitySet());
        return dto;
    }

    @Override
    public Option fromDto(OptionDTO dto) {
        Option option = new Option();
        option.setName(dto.getName());
        option.setSpecialitySet(dto.getSpecialities());
        return option;
    }

    @Override
    public List<OptionDTO> toDtoList(List<Option> documentList) {
        if(documentList != null && !documentList.isEmpty())
            return documentList.stream().map(this::toDto).collect(Collectors.toList());
        return Collections.emptyList();
    }

    @Override
    public List<Option> fromDtoList(List<OptionDTO> dtoList) {
        if(dtoList != null && !dtoList.isEmpty())
            return dtoList.stream().map(this::fromDto).collect(Collectors.toList());
        return Collections.emptyList();
    }
}
