package com.cytech.cytechback.subject;

import com.cytech.cytechback.common.SimpleAssembler;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectAssembler implements SimpleAssembler<SubjectDTO, Subject> {
    @Override
    public SubjectDTO toDto(Subject s) {
        SubjectDTO dto = new SubjectDTO();
        dto.setName(s.getName());
        dto.setUe(s.getUe());
        return dto;
    }

    @Override
    public Subject fromDto(SubjectDTO dto) {
        return null;
    }

    @Override
    public List<SubjectDTO> toDtoList(List<Subject> documentList) {
        if (documentList != null && !documentList.isEmpty())
            return documentList.stream().map(this::toDto).collect(Collectors.toList());
        return Collections.emptyList();
    }

    @Override
    public List<Subject> fromDtoList(List<SubjectDTO> dtoList) {
        return null;
    }
}
