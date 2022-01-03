package com.cytech.cytechback.message;

import com.cytech.cytechback.common.SimpleDto;
import com.cytech.cytechback.user.User;

public class MessageDTO implements SimpleDto {

    private Long id;
    private String content;
    private User sender;
    private User receiver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}
