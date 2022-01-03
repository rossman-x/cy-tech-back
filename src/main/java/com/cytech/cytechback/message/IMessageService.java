package com.cytech.cytechback.message;

import java.util.List;

public interface IMessageService {

    void createMessage(MessageDTO dto);

    List<MessageDTO> getReceivedMessages(int user_id);
}
