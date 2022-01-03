package com.cytech.cytechback.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return userAssembler.toDtoList(users);
    }

    @Override
    public UserDTO auth(String email, String password) throws Exception {
        try {
            User user = userRepository.findUserByEmailAddressAndPassword(email, password);
            if (user == null)
                throw new Exception("User not found");
            return this.userAssembler.toDto(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }

    }

    @Override
    public UserDTO getUserById(int id) {
        User u = userRepository.findUserById(id);
        return this.userAssembler.toDto(u);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User u = this.userAssembler.fromDto(userDTO);
        User savedUser = this.userRepository.save(u);
        return this.userAssembler.toDto(savedUser);
    }
}
