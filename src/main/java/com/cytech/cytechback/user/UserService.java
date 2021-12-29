package com.cytech.cytechback.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return userAssembler.toDtoList(users);
    }
}
