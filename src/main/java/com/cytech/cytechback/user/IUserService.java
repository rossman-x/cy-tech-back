package com.cytech.cytechback.user;

import java.util.List;

public interface IUserService {

    List<UserDTO> getUsers();

    UserDTO auth(String email, String password) throws Exception;

    UserDTO getUserById(int id);

    UserDTO createUser(UserDTO userDTO);

}
