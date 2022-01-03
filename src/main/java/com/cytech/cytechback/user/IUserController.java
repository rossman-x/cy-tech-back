package com.cytech.cytechback.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IUserController {

    @Operation(summary = "Get All users")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<List<UserDTO>> getUsers();

    @Operation(summary = "Get one user using credentials")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "403", content = @Content)})
    ResponseEntity<UserDTO> getUserByCredentials(@RequestParam("email") String email, @RequestParam("password") String password);


    @Operation(summary = "Get one user by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<UserDTO> getUserById(@RequestParam("user_id") int id);

    @Operation(summary = "Create a new user using userDTO")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO);
}