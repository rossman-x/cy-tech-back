package com.cytech.cytechback.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface MessageRepository extends JpaRepository<Message, Long> {
    Set<Message> findAllByReceiverId(Long senderId);
}
