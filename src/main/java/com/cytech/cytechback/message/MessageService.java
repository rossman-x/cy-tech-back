package com.cytech.cytechback.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageAssembler messageAssembler;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void createMessage(MessageDTO dto) {
        Message message = this.messageAssembler.fromDto(dto);
        this.messageRepository.save(message);
    }

    @Override
    public List<MessageDTO> getReceivedMessages(int user_id) {
        Set<Message> messageSet = this.messageRepository.findAllByReceiverId(Long.valueOf(user_id));
        List<Message> messageList = messageSet.stream().collect(Collectors.toList());
        return this.messageAssembler.toDtoList(messageList);
    }

    @Override
    public void deleteMessage(int messageId) {
        this.messageRepository.deleteById(Long.valueOf(messageId));
    }
}
