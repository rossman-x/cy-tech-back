package com.cytech.cytechback.message;

import com.cytech.cytechback.common.SimpleAssembler;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageAssembler implements SimpleAssembler<MessageDTO, Message> {
    @Override
    public MessageDTO toDto(Message document) {
        MessageDTO dto = new MessageDTO();
        dto.setId(document.getId());
        dto.setContent(document.getContent());
        dto.setReceiver(document.getReceiver());
        dto.setSender(document.getSender());
        return dto;
    }

    @Override
    public Message fromDto(MessageDTO dto) {
        Message m = new Message();
        m.setId(dto.getId());
        m.setReceiver(dto.getReceiver());
        m.setSender(dto.getSender());
        m.setContent(dto.getContent());
        return m;
    }

    @Override
    public List<MessageDTO> toDtoList(List<Message> documentList) {
        if (documentList != null && !documentList.isEmpty())
            return documentList.stream().map(this::toDto).collect(Collectors.toList());
        return Collections.emptyList();
    }

    @Override
    public List<Message> fromDtoList(List<MessageDTO> dtoList) {
        if (dtoList != null && !dtoList.isEmpty())
            return dtoList.stream().map(this::fromDto).collect(Collectors.toList());
        return Collections.emptyList();
    }
}
