package com.cytech.cytechback.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController implements IMessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(path = "/create")
    @Override
    public ResponseEntity<Void> createMessage(MessageDTO messageDTO) {
        this.messageService.createMessage(messageDTO);
        return null;
    }

    @GetMapping(path = "/received")
    @Override
    public ResponseEntity<List<MessageDTO>> getReceivedMessage(int user_id) {
        return ResponseEntity.ok(this.messageService.getReceivedMessages(user_id));
    }
}
