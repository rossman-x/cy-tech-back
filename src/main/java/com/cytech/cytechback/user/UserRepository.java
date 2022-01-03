package com.cytech.cytechback.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAddressAndPassword(String emailAddress, String password) throws HttpClientErrorException.NotFound;

    User findUserById(long id);

}
