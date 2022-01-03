package com.cytech.cytechback.user;

import io.swagger.models.Response;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController implements IUserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "list")
    @Override
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(path = "auth")
    @Override
    public ResponseEntity<UserDTO> getUserByCredentials(String email, String password) {
        try {
            return ResponseEntity.ok().body(userService.auth(email, password));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "")
    @Override
    public ResponseEntity<UserDTO> getUserById(int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping(path = "create")
    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        return ResponseEntity.ok(this.userService.createUser(userDTO));
    }
}
