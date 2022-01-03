package com.cytech.cytechback.criteria;

import com.cytech.cytechback.common.SimpleAssembler;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CriteriaAssembler implements SimpleAssembler<CriteriaDTO, Criteria>{
    @Override
    public CriteriaDTO toDto(Criteria c) {
        CriteriaDTO dto = new CriteriaDTO();
        dto.setContent(c.getContent());
        dto.setOption(c.getOption());
        return dto;
    }

    @Override
    public Criteria fromDto(CriteriaDTO dto) {
        Criteria c = new Criteria();
        c.setContent(dto.getContent());
        c.setOption(dto.getOption());
        return c;
    }

    @Override
    public List<CriteriaDTO> toDtoList(List<Criteria> documentList) {
        if(documentList != null && !documentList.isEmpty())
            return documentList.stream().map(this::toDto).collect(Collectors.toList());
        return Collections.emptyList();
    }

    @Override
    public List<Criteria> fromDtoList(List<CriteriaDTO> dtoList) {
        if(dtoList != null && !dtoList.isEmpty())
            return dtoList.stream().map(this::fromDto).collect(Collectors.toList());
        return Collections.emptyList();
    }
}
